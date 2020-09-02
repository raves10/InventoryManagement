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
public class Flavours {
    
    private String fname;

    /*parameterised construtor*/
    public Flavours(String fname) {
        this.fname = fname;
    }

    /*getters and setters*/
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    /*toString to print the content*/
    @Override
    public String toString() {
        return "Flavours{" + "fname=" + fname + '}';
    }
    
    
    
}
