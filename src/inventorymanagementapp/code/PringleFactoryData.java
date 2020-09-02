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
public class PringleFactoryData {

    private static Ingredients iobj;
    private static Flavours fobj;
    private static LinkedHashMap<String,ProductDetails> pringleStockList = new LinkedHashMap<>();
    private static PringlesFactory pfactory = new PringlesFactory();
    
    
     /* creating data and storing in LinkedHashMap<String,ProductDetails>*/
    public static void createData()
    {
        fobj= pfactory.createFlavours("BBQ");
        iobj= pfactory.createIngredients("Potato,Onion,Garlic,Herbs", "80");
        pfactory.createProductDetails("Pringles BBQ", 30, 2.13 ,"Enjoy the taste of BBQ",iobj,fobj);
        
        fobj =pfactory.createFlavours("Plain");
        iobj= pfactory.createIngredients("Potato,Salt,Herbs", "89");
        pfactory.createProductDetails("Pringles Plain", 46, 1.13 ,"Enjoy the taste of Plain salted pringles",iobj,fobj);
        
        fobj=pfactory.createFlavours("Sour&Cream");
        iobj=pfactory.createIngredients("Potato,Onion,Garlic,Herbs,Cream", "75");
        pfactory.createProductDetails("Pringles Sour&Cream", 30, 3.13 ,"Enjoy the taste of Sour&Cream",iobj,fobj);
        
        fobj=pfactory.createFlavours("Ranch");
        iobj=pfactory.createIngredients("Potato,Onion,Garlic,Herbs,Ranch", "90");
        pfactory.createProductDetails("Pringles Ranch", 20, 4.13 ,"Enjoy the taste of Ranch",iobj,fobj);
        
    } 
    
    /*getters and setters for LinkedHashMap<String,ProductDetails> */
    public static LinkedHashMap<String, ProductDetails> getPringleStockList() {
        return pringleStockList;
    }

    
    public static void setPringleStockList(ProductDetails product) {
        
        System.out.println("set ");
        pringleStockList.put("Pringles"+product.getProduct().getProdId(), product);
    }
    
     /* print method to diaplay content of LinkedHashMap<String,ProductDetails>*/
    public static void print()
    {
        pringleStockList.entrySet().stream().forEach(p -> System.out.println(p.getKey()+":"+p.getValue()));
    }
}
