/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp;

import inventorymanagementapp.MenuController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author radhi
 */
public class MainPageController {
    
    private Parent parent;
    private Scene scene;
    private Stage stage;
    
    private MenuController menuController;
    @FXML
    private Label label;
    
    
    
    @FXML
    private void handleRadioButtonSelected(ActionEvent event) throws IOException{
        String radioText = ((RadioButton) event.getSource()).getText();//radio button text
        
        System.out.println("radiotext"+radioText);
        menuController = new MenuController();
        System.out.println("stage"+stage);
        menuController.launchcontroller(new Stage(), radioText); //pass table number into order controller 
        
    }
    
    //Launch screen
    public void launchcontroller(Stage stage) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("view/MainPage.fxml"));
        scene = new Scene(root);
        this.stage = stage;
        stage.setTitle("Inventory Management App");
        stage.setScene(scene);
        stage.setResizable(false);
        //stage.hide();
        stage.show();
    }
    
}
