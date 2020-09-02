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
public final class Product {
    
    private int prodId;

    
  /*parameterised construtor*/
    public Product(int prodId) {
        this.prodId = prodId;
    }

     /*getters and setters*/
    public int getProdId() {
        return prodId;
    }

    /*toString to print the content*/
    @Override
    
    
    public String toString() {
        return "Product{" + "prodId=" + prodId + '}';
    }
    
    
    
}
