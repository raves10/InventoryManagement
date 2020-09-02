/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp;

import inventorymanagementapp.code.LaysFactoryData;
import inventorymanagementapp.code.PringleFactoryData;
import inventorymanagementapp.code.VeganFactoryData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author radhi
 */
public class InventoryManagementApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("r"+getClass().getResource("view/MainPage.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("view/MainPage.fxml"));
                Scene scene = new Scene(root);
        stage.setTitle("Inventory Management");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PringleFactoryData.createData();
        LaysFactoryData.createData();
        VeganFactoryData.createData();
        launch(args);
    }
    
}
