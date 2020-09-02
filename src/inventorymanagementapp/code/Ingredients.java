/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp.code;

/**
 *
 * @author radhi
 */
public class Ingredients {
    
    private String ingredients;
    private String purity;

    /*parameterised construtor*/
    public Ingredients(String ingredients, String purity) {
        this.ingredients = ingredients;
        this.purity = purity;
    }

    /*getters and setters*/
    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    /*toString to print the content*/
    @Override
    public String toString() {
        return "Ingredients{" + "ingredients=" + ingredients + ", purity=" + purity + '}';
    }
    
    
    
}
