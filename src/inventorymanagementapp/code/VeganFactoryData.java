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
public class VeganFactoryData
{
    private static Ingredients iobj;
    private static Flavours fobj;
    private static LinkedHashMap<String,ProductDetails> veganStockList = new LinkedHashMap<>();
    private static VeganFactory vfactory = new VeganFactory();
    
    /* creating data and storing in LinkedHashMap<String,ProductDetails>*/
    public static void createData()
    {
        fobj= vfactory.createFlavours("BBQ");
        iobj= vfactory.createIngredients("Potato,Onion,Garlic,Herbs", "80");
        vfactory.createProductDetails("Vegan BBQ", 30, 2.13 ,"Enjoy the taste of BBQ",iobj,fobj);
        
        fobj =vfactory.createFlavours("Plain");
        iobj= vfactory.createIngredients("Potato,Salt,Herbs", "89");
        vfactory.createProductDetails("Vegan Plain", 46, 1.13 ,"Enjoy the taste of Plain salted pringles",iobj,fobj);
        
        fobj=vfactory.createFlavours("Sour&Cream");
        iobj=vfactory.createIngredients("Potato,Onion,Garlic,Herbs,Cream", "75");
        vfactory.createProductDetails("Vegan Sour&Cream", 30, 3.13 ,"Enjoy the taste of Sour&Cream",iobj,fobj);
        
        fobj=vfactory.createFlavours("Ranch");
        iobj=vfactory.createIngredients("Potato,Onion,Garlic,Herbs,Ranch", "90");
        vfactory.createProductDetails("Vegan Ranch", 20, 4.13 ,"Enjoy the taste of Ranch",iobj,fobj);
        
    } 
    
     /*getters and setters for LinkedHashMap<String,ProductDetails> */
    public static LinkedHashMap<String, ProductDetails> getVeganStockList() {
        return veganStockList;
    }

    
    public static void setVeganStockList(ProductDetails product) {
        
        System.out.println("set ");
        veganStockList.put("Vegan"+product.getProduct().getProdId(), product);
    }
    
    /* print method to diaplay content of LinkedHashMap<String,ProductDetails>*/
    public static void print()
    {
        veganStockList.entrySet().stream().forEach(p -> System.out.println(p.getKey()+":"+p.getValue()));
    }
}
