/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

import java.util.LinkedHashMap;

/**
 *
 * @author radhi
 */
public class LaysFactoryData {
    private static Ingredients iobj;
    private static Flavours fobj;
    private static LinkedHashMap<String,ProductDetails> laysStockList = new LinkedHashMap<>();
    private static LaysFactory lfactory = new LaysFactory();
    
    /* creating data and storing in LinkedHashMap<String,ProductDetails>*/
    
    public static void createData()
    {
        fobj= lfactory.createFlavours("BBQ");
        iobj= lfactory.createIngredients("Potato,Onion,Garlic,Herbs", "80");
        lfactory.createProductDetails("Lays BBQ", 30, 2.13 ,"Enjoy the taste of BBQ",iobj,fobj);
        
        fobj =lfactory.createFlavours("Plain");
        iobj= lfactory.createIngredients("Potato,Salt,Herbs", "89");
        lfactory.createProductDetails("Lays Plain", 46, 1.13 ,"Enjoy the taste of Plain salted pringles",iobj,fobj);
        
        fobj=lfactory.createFlavours("Sour&Cream");
        iobj=lfactory.createIngredients("Potato,Onion,Garlic,Herbs,Cream", "75");
        lfactory.createProductDetails("Lays Sour&Cream", 30, 3.13 ,"Enjoy the taste of Sour&Cream",iobj,fobj);
        
        fobj=lfactory.createFlavours("Ranch");
        iobj=lfactory.createIngredients("Potato,Onion,Garlic,Herbs,Ranch", "90");
        lfactory.createProductDetails("Lays Ranch", 20, 4.13 ,"Enjoy the taste of Ranch",iobj,fobj);
        
    } 
    
        /*getters and setters for LinkedHashMap<String,ProductDetails> */
    public static LinkedHashMap<String, ProductDetails> getLaysStockList() {
        return laysStockList;
    }

    
    public static void setLaysStockList(ProductDetails product) {
        
        System.out.println("set ");
        laysStockList.put("Lays"+product.getProduct().getProdId(), product);
    }
    
     /* print method to diaplay content of LinkedHashMap<String,ProductDetails>*/
    public static void print()
    {
        laysStockList.entrySet().stream().forEach(p -> System.out.println(p.getKey()+":"+p.getValue()));
    }
}
