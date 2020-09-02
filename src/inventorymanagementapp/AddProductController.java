/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp;

import inventorymanagementapp.code.Mediator;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author radhi
 * 
 */





public class AddProductController {

@FXML
private TextField ingredients;

@FXML
private TextField purity;

@FXML
private TextField flavour;

@FXML
private TextField pname;

@FXML
private TextField pdesc;

@FXML
private TextField pstock;

@FXML
private TextField pprice;

@FXML
private Label msg;

@FXML
private Label addbrand;

private Parent parent;
private Scene scene;
private Stage stage;
private MenuController menuController;


private String brand;



public AddProductController() {

        //fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/AddProduct.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


    public void handleAddButton(ActionEvent event) 
    {
        String btnText = ((Button) event.getSource()).getText();
        System.out.println("button"+btnText);
        
                   
        if (btnText.equalsIgnoreCase("Add Product!")) { 

            String indgredients = ingredients.getText();
            String ipurity = purity.getText();
            String iflavout = flavour.getText();
            String name = pname.getText();
            String desc = pdesc.getText();
            int stock = Integer.parseInt(pstock.getText());
            double price = Double.parseDouble(pprice.getText());
            Mediator mediator = new Mediator();
            String result = mediator.performAddFunction(addbrand.getText(),indgredients,ipurity,iflavout,name,desc,stock,price);
            msg.setText(result);
            
    }else if(btnText.equalsIgnoreCase("back"))
    {
            menuController = new MenuController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            menuController.launchcontroller(stg, addbrand.getText());
            }
            catch(Exception e)
            {
                System.out.println("Add controller "+e.getMessage());
            }
    }
    
            
    }
    
    public void launchcontroller(Stage stage, String brandSelection) throws IOException{
        
        //System.out.println("inside add product launch");
       // Parent root = FXMLLoader.load(getClass().getResource("view/AddProduct.fxml"));
       // scene = new Scene(root);
        this.stage = stage;
        System.out.println("stage"+this.stage);
        this.brand = brandSelection;
        this.stage.setTitle(brandSelection +" Add Product");
        this.stage.setScene(scene);
        System.out.println("----"+addbrand);
        this.stage.setResizable(false);
        addbrand.setText(brandSelection);
        this.stage.show();
    }
    
}
