/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp;

import inventorymanagementapp.code.Mediator;
import inventorymanagementapp.code.ProductDetails;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author radhi
 */
public class UpdateProductController {

@FXML
private Label msg;

@FXML
private Label updatebrand;

//Combobox
    @FXML
    private ComboBox prodCombo;

private Parent parent;
private Scene scene;
private Stage stage;
private MenuController menuController;

private String brand;
private LinkedHashMap<String,ProductDetails> prodMap;
private Mediator mediator;
private int prodId, count;
private double price;

@FXML
private TextField counttext; 

@FXML
private TextField pricetext;


public UpdateProductController() {

        //fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/UpdateProduct.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void changeMenu(ActionEvent event)
    {
        String option = prodCombo.getSelectionModel().getSelectedItem().toString();
        System.out.println("option"+option.trim());
        System.out.println("00000"+prodMap.size());
        for (Map.Entry<String,ProductDetails> product: prodMap.entrySet()) {
            
            if(product.getValue().getName().equalsIgnoreCase(option.trim()))
            {
                prodId = product.getValue().getProduct().getProdId();
            }
        }
    }

    
    @FXML
    public void getCount(ActionEvent e)
    {
        System.out.println("count get"+count);
        count = Integer.parseInt(counttext.getText());
    }
    
    
    @FXML
    public void getprice(ActionEvent e)
    {
        price = Double.parseDouble(pricetext.getText());
    }
    
    @FXML
    public void handleUpdate(ActionEvent event) 
    {
        String btnText = ((Button) event.getSource()).getText();
        if (btnText.equalsIgnoreCase("Update Product")) { 
            System.out.println("count" + count + "price" + price);
         String result= mediator.performUpdateFunction(updatebrand.getText(),prodId,Integer.parseInt(counttext.getText()),Double.parseDouble(pricetext.getText()));
         msg.setText(result);
        }
        else if (btnText.equalsIgnoreCase("Back"))
        {
            menuController = new MenuController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            menuController.launchcontroller(stg, updatebrand.getText());
            }
            catch(Exception e)
            {
                System.out.println("update controller "+e.getMessage());
            }
        }
    }
    
    public void launchcontroller(Stage stage, String brandSelection) {
        
        //System.out.println("inside add product launch");
       // Parent root = FXMLLoader.load(getClass().getResource("view/AddProduct.fxml"));
       // scene = new Scene(root);
        this.stage = stage;
        System.out.println("stage"+this.stage);
        this.brand = brandSelection;
        this.stage.setTitle(brandSelection +" Update Product");
        this.stage.setScene(scene);
        System.out.println("----"+updatebrand);
        this.stage.setResizable(false);
        updatebrand.setText(brandSelection);
        prodCombo.getItems().removeAll(prodCombo.getItems());
        
        System.out.println("inside display list");
        mediator = new Mediator();
        System.out.println("[[[[[[[[["+updatebrand.getText());
        prodMap= mediator.getProdMap(updatebrand.getText());
        System.out.println("00000"+prodMap.size());
        for (Map.Entry<String,ProductDetails> product: prodMap.entrySet()) {
            
            prodCombo.getItems().add(product.getValue().getName());
        }
        
        
        this.stage.show();
    }
    
    

    
}
