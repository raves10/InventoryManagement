/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

import java.util.LinkedHashMap;

/*factory interface with all the functions*/
public interface ProductInterface {
    
    public String addProduct(String indgredients,String ipurity,String iflavout,String name,String desc,int stock,double price);
    public String deleteProduct(int prodId);
    public int checkStock(int prodId);
    
    public String updateProduct(int prodId,int count,double price);
    public Ingredients createIngredients(String ingredients,String purity);
    public Flavours createFlavours(String name);
    public ProductDetails createProductDetails(String name, int count, double price,  String description,Ingredients ingredients, Flavours flavour);
    public LinkedHashMap<String,ProductDetails> getProducts();
            
}
