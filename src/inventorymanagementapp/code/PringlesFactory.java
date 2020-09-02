/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author radhi
 */
public class PringlesFactory implements ProductInterface{

    
    
    private String factoryName="Pringles";
    private LinkedHashMap<String,ProductDetails> pringleStockList;
    private int IdCount = 100;
    private ProductDetails productDetails;
    private Scanner input = new Scanner(System.in);
    
    
    
    /* add product method */
    @Override
    public String addProduct(String indgredients,String ipurity,String iflavout,String name,String desc,int stock,double price) {
        
        
        Ingredients iobj =createIngredients(indgredients, ipurity);
        Flavours fobj = createFlavours(iflavout);
        if(createProductDetails(name, stock, price, desc,iobj,fobj)!=null)
        {
          
           return "Product created and added successfully!";
        }
        else
        {
            return "Some error occured!";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* delete product method by productId*/
    @Override
    public String deleteProduct(int prodId) {
        
        PringleFactoryData.getPringleStockList().remove("Pringles"+prodId);
        
        
                return "Product deleted successfully";
            
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      /* check product stock method by productId*/
    @Override
    public int checkStock(int prodId) {
        
        return PringleFactoryData.getPringleStockList().get("Pringles"+prodId).getCount();
        

        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    /* update product stock or price method by productId. Update is performed only if count and prrice is greater than 0*/
    @Override
    public String updateProduct(int prodId,int count ,double price) {
        
        PringleFactoryData.print();
        ProductDetails product = PringleFactoryData.getPringleStockList().get("Pringles"+prodId);
        
        System.out.println("count factory"+count);
                
                 if(count!=0)
                 {
                     
                     product.setCount(count);
                 }
                 if(price!=0.0)
                 {
                     product.setPrice(price);
                 }
                
                PringleFactoryData.getPringleStockList().put("Pringles"+prodId, product);
         PringleFactoryData.print();
                 return "Product updated successfully!";
                   
                
                
           
            
            
        }

        
        
/* creating Ingredients object for product*/ 
    @Override
    public Ingredients createIngredients(String ingredients, String purity) {
        
        return new Ingredients(ingredients, purity);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* creating Flavours object for product*/
    @Override
    public Flavours createFlavours(String name) {
        return new Flavours(name);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* creating Immutable Product object for product*/
    public Product createProduct() {
        
              	 
        return new Product(new Random().nextInt()+1);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* creating ProductDetails object for product*/
    @Override
    public ProductDetails createProductDetails(String name, int count, double price, String description,Ingredients ingredients, Flavours flavour) {
        
        Product prod=createProduct();
        IdCount++;
        productDetails = new ProductDetails(name, count, price,prod, description,ingredients,flavour);
        
        PringleFactoryData.setPringleStockList(productDetails);
        
        return productDetails;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /* getter for all Pringles products in inventory*/
    @Override
    public LinkedHashMap<String, ProductDetails> getProducts() {
        
        System.out.println("product "+ PringleFactoryData.getPringleStockList().size());
        return PringleFactoryData.getPringleStockList();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
