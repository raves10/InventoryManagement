/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 *
 * @author radhi
 */
public class VeganFactory implements ProductInterface,VeganFactoryMarker{

    
    
    private String factoryName="Vegan";
    private ProductDetails productDetails;
    
    
    /* add product method */
    @Override
    public String addProduct(String indgredients,String ipurity,String iflavout,String name,String desc,int stock,double price) {
        
        
        Ingredients iobj =createIngredients(indgredients, ipurity);
        Flavours fobj = createFlavours(iflavout);
        if(createProductDetails(name, stock, price, desc,iobj,fobj)!=null)
        {
          
           return "Product created and added successfully! 20% discount offered on price";
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
        
        VeganFactoryData.getVeganStockList().remove(factoryName+prodId);
        
        
                return "Product deleted successfully";
            
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      /* check product stock method by productId*/
    @Override
    public int checkStock(int prodId) {
        
        return VeganFactoryData.getVeganStockList().get(factoryName+prodId).getCount();
        

        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    /* update product stock or price method by productId. Update is performed only if count and prrice is greater than 0*/
    @Override
    public String updateProduct(int prodId,int count ,double price) {
        
        VeganFactoryData.print();
        ProductDetails product = VeganFactoryData.getVeganStockList().get(factoryName+prodId);
        boolean flag=false;
        System.out.println("count factory"+count);
                
                 if(count!=0)
                 {
                     
                     product.setCount(count);
                 }
                 if(price!=0.0)
                 {
                     product.setPrice(price);
                     flag=true;
                 }
                
         VeganFactoryData.getVeganStockList().put(factoryName+prodId, product);
         VeganFactoryData.print();
         
         if(flag)
         {
             return "Product updated successfully! 10% discount offered on price";
         }
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
      
        productDetails = new ProductDetails(name, count, price,prod, description,ingredients,flavour);
        
        VeganFactoryData.setVeganStockList(productDetails);
        
        return productDetails;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* getter for all Vegan products in inventory*/ 
    @Override
    public LinkedHashMap<String, ProductDetails> getProducts() {
        
        System.out.println("product "+ VeganFactoryData.getVeganStockList().size());
        return VeganFactoryData.getVeganStockList();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}

