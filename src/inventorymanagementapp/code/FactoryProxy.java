/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author radhi
 */
public class FactoryProxy implements ProductInterface{

    @Override
    public String addProduct(String indgredients, String ipurity, String iflavout, String name, String desc, int stock, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteProduct(int prodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkStock(int prodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public String updateProduct(int prodId, int count, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ingredients createIngredients(String ingredients, String purity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Flavours createFlavours(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductDetails createProductDetails(String name, int count, double price, String description, Ingredients ingredients, Flavours flavour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*proxy methhod to get all product based on brand */
    public LinkedHashMap<String, ProductDetails> getProducts(String brand) {
        
        if("Pringles".equalsIgnoreCase(brand))
        {
            return PringleFactoryData.getPringleStockList();
        }
        else if("Lays".equalsIgnoreCase(brand))
        {
            return LaysFactoryData.getLaysStockList();
        }
        else if("Vegan".equalsIgnoreCase(brand))
        {
            return VeganFactoryData.getVeganStockList();
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public LinkedHashMap<String, ProductDetails> getProducts() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*proxy methhod to get all product based on brand and returns the List<ProductDetails>*/
    public List<ProductDetails> getProductList(String brand)
    {
        List<ProductDetails> products = new ArrayList<>();
        if("Pringles".equalsIgnoreCase(brand))
        {
            PringleFactoryData.getPringleStockList().entrySet().stream().forEach(p-> products.add(p.getValue()));
        }
        else if("Lays".equalsIgnoreCase(brand))
        {
            LaysFactoryData.getLaysStockList().entrySet().stream().forEach(p-> products.add(p.getValue()));
        }
        else if("Vegan".equalsIgnoreCase(brand))
        {
            VeganFactoryData.getVeganStockList().entrySet().stream().forEach(p-> products.add(p.getValue()));
        }
        return products;
    }
    
}
