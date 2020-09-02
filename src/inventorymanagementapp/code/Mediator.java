/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author radhi
 */
public class Mediator {
    
   
   private ProductInterface factory;
    
    private FactoryProxy fproxy;
    
    
    /* add product method */
    public String performAddFunction(String  brand,String indgredients,String ipurity,String iflavout,String name,String desc,int stock,double price)
    {
        if(brand.equalsIgnoreCase("pringles"))
        {
            if(factory==null)
            {
            factory= new PringlesFactory();
            
            }
        }
        else if(brand.equalsIgnoreCase("lays"))
        {
            if(factory==null)
            {
            factory= new LaysFactory();
            
            }
        }
        else if(brand.equalsIgnoreCase("vegan"))
        {
            if(factory==null)
            {
            factory= new VeganFactory();
            
            }
            
        }
        
        /* if the factory is instance of VeganMarker then 20 % discount is offered on price on adding new product*/
        if(factory instanceof VeganFactoryMarker)
        {
            double discountedPrice =price - price*20 /100;
            String result=  factory.addProduct(indgredients,ipurity,iflavout,name,desc,stock,discountedPrice);
            System.out.println("Add product "+ brand +" result: "+result);
            return result;
        }
        else
        {
            String result=  factory.addProduct(indgredients,ipurity,iflavout,name,desc,stock,price);
            System.out.println("Add product "+ brand +" result: "+result);
            return result;
        
        }
       
    }
    
    /* uses proxy method to get all products for respective brand instead of creting object of factory*/
    public LinkedHashMap<String,ProductDetails> getProdMap(String brand)
    {
        fproxy = new FactoryProxy();
         return fproxy.getProducts(brand);
        
       // return null;
        
    }
    
    /* update product stock or price method by productId. */
    public String performUpdateFunction(String brand, int prodId,int count,double price)
    {
        if(brand.equalsIgnoreCase("pringles"))
        {
        if(factory==null)
            {
            factory= new PringlesFactory();
            
            }
        }
        else if (brand.equalsIgnoreCase("lays"))
        {
            if(factory==null)
            {
            factory= new LaysFactory();
            
            }
        }
        else if(brand.equalsIgnoreCase("vegan"))
        {
            if(factory==null)
            {
            factory= new VeganFactory();
            
            }
            
        }
        
        /* if the factory is instance of VeganMarker then 10 % discount is offered on price on update price of product*/
        if(factory instanceof VeganFactoryMarker)
        {
            double discountedPrice=0.0;
            if(price!=0.0)
            {
                discountedPrice =price - price*10 /100;
            }
            String result = factory.updateProduct(prodId,count,discountedPrice);
            System.out.println("factory.updateProduct(prodId,count,price) "+result);
            return result;
    
        }
        else
        {
            String result = factory.updateProduct(prodId,count,price);
            System.out.println("factory.updateProduct(prodId,count,price) "+result);
            return result;
    
        
        }
        
        
    }
    
    /* delete product method by productId*/
    public String performDeleteFunction(String brand, int prodId)
    {
        if(brand.equalsIgnoreCase("pringles"))
        {
        if(factory==null)
            {
            factory= new PringlesFactory();
            
            }
        }
        else if(brand.equalsIgnoreCase("lays"))
        {
            if(factory==null)
            {
            factory= new LaysFactory();
            
            }
            
        }
        else if(brand.equalsIgnoreCase("vegan"))
        {
            if(factory==null)
            {
            factory= new VeganFactory();
            
            }
            
        }
        String result = factory.deleteProduct(prodId);
            System.out.println("factory.updateProduct(prodId,count,price) "+result);
            return result;
    
        
        
    }
    
    /* check product stock method by productId*/
    public String performStockFunction(String brand, int prodId)
    {
        if(brand.equalsIgnoreCase("pringles"))
        {
        if(factory==null)
            {
            factory= new PringlesFactory();
           
            }
        }
        else if(brand.equalsIgnoreCase("lays"))
        {
            if(factory==null)
            {
            factory= new LaysFactory();
            
            }
        }
        else if(brand.equalsIgnoreCase("vegan"))
        {
            if(factory==null)
            {
            factory= new VeganFactory();
            
            }
            
        }
        String result = String.valueOf(factory.checkStock(prodId));
            System.out.println("factory.updateProduct(prodId,count,price) "+result);
            return result;
    
    }
    
    /* uses proxy method to return List<ProductDetails> instead of creating object of factory*/
    public List<ProductDetails> getProductList(String brand)
    {
        fproxy = new FactoryProxy();
         return fproxy.getProductList(brand);
    }
}
