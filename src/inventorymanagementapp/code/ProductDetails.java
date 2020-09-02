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
public class ProductDetails {

       
    private String name;
    private int count;
    private double price;
    private Product product;
    private String description;
    private Ingredients ingredients;
    private Flavours flavour;

      /*parameterised construtor*/
    public ProductDetails(String name, int count, double price, Product product, String description, Ingredients ingredients, Flavours flavour) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.product = product;
        this.description = description;
        this.ingredients = ingredients;
        this.flavour = flavour;
    }

    /*getters and setters*/
    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Flavours getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavours flavour) {
        this.flavour = flavour;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    /*toString to print the content*/
    @Override
    public String toString() {
        return "ProductDetails{" + "name=" + name + ", count=" + count + ", price=" + price + ", product=" + product + ", description=" + description + ", ingredients=" + ingredients + ", flavour=" + flavour + '}';
    }

    
    
    
    
    
}
