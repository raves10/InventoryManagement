/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp;

import inventorymanagementapp.code.Mediator;
import inventorymanagementapp.code.ProductDetails;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author radhi
 */
public class CheckStockController {
    
   
    private Parent parent;
    private Scene scene;
    private Stage stage;
@FXML
private Label stockbrand;

@FXML
private ComboBox prodCombo;

@FXML
private Label msg;

private Mediator mediator;
private LinkedHashMap<String,ProductDetails> prodMap;
private int prodId;
private MenuController menuController;
//Constructor
    public CheckStockController() {

        //fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/CheckStock.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void launchcontroller(Stage stage, String brandSelection) throws IOException{
        
        //System.out.println("resource"+getClass().getResource("view/MenuPage.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("view/MenuPage.fxml"));
        
        //scene = new Scene(root);
        this.stage = stage;
        System.out.println("stage"+this.stage);
       
        this.stage.setTitle(brandSelection +" Check Stock");
        this.stage.setScene(scene);
        System.out.println("88888"+stockbrand);
        
        stockbrand.setText(brandSelection);
        this.stage.setResizable(false);
        prodCombo.getItems().removeAll(prodCombo.getItems());
        
        System.out.println("inside display list");
        mediator = new Mediator();
        System.out.println("[[[[[[[[["+stockbrand.getText());
        prodMap= mediator.getProdMap(stockbrand.getText());
        System.out.println("00000"+prodMap.size());
        for (Map.Entry<String,ProductDetails> product: prodMap.entrySet()) {
            
            System.out.println("product.getValue().getName()"+product.getValue().getName());
            prodCombo.getItems().add(product.getValue().getName());
        }
        this.stage.show();
    }
    
    @FXML
    public void changeContent(ActionEvent event)
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
    public void handleStock(ActionEvent event) throws Exception
    {
        String btnText = ((Button) event.getSource()).getText();
        if (btnText.equalsIgnoreCase("Check Stock")) { 
         String result= mediator.performStockFunction(stockbrand.getText(),prodId);
         msg.setText("The current available stock is "+result);
        }
        else if (btnText.equalsIgnoreCase("Back"))
        {
            menuController = new MenuController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            menuController.launchcontroller(stg, stockbrand.getText());
        }
    }
    
}
