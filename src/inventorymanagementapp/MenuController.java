/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementapp;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author radhi
 */
public class MenuController {
    
    private Parent parent;
    private Scene scene;
    private Stage stage;
    private MainPageController mainController;
    private AddProductController addController;
    private String brand;
    private UpdateProductController updateController;
    private DeleteProductController deleteController;
    private CheckStockController checkStockController;
    private DisplayProductController displayProductController;
@FXML
private Label brand_lable;
    //Constructor
    public MenuController() {

        //fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/MenuPage.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void launchcontroller(Stage stage, String brandSelection) {
        
        //System.out.println("resource"+getClass().getResource("view/MenuPage.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("view/MenuPage.fxml"));
        
        //scene = new Scene(root);
        this.stage = stage;
        System.out.println("stage"+this.stage);
        this.brand = brandSelection;
        this.stage.setTitle(brandSelection +" "
                + "Menu");
        this.stage.setScene(scene);
        System.out.println("88888"+brand_lable);
        
        brand_lable.setText(brandSelection);
        this.stage.setResizable(false);
        
        this.stage.show();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        String btnText = ((Button) event.getSource()).getText();
        System.out.println("inside"+btnText);
        if (btnText.equalsIgnoreCase("Back")) { 

            mainController = new MainPageController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            mainController.launchcontroller(stg);
            }
            catch(IOException e)
            {
                System.out.println("Menu controller "+e.getMessage());
            }
        }else if (btnText.equalsIgnoreCase("Add Product"))
        {
            System.out.println("inside");
            addController = new AddProductController();
            Stage stg = new Stage() ;
            try
            {
            addController.launchcontroller(stg, brand_lable.getText());
            }
            catch(IOException e)
            {
                System.out.println("Menu controller "+e.getMessage());
            }
        }
        else if(btnText.equalsIgnoreCase("update product"))
    {
            updateController = new UpdateProductController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            updateController.launchcontroller(stg, brand_lable.getText());
            }
            catch(Exception e)
            {
                System.out.println("Menu controller "+e.getMessage());
            }
    }else if(btnText.equalsIgnoreCase("delete product"))
    {
            deleteController = new DeleteProductController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            deleteController.launchcontroller(stg, brand_lable.getText());
            }
            catch(IOException e)
            {
                System.out.println("Menu controller "+e.getMessage());
            }
    }
        else if(btnText.equalsIgnoreCase("check stock"))
    {
            checkStockController = new CheckStockController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            checkStockController.launchcontroller(stg, brand_lable.getText());
            }
            catch(IOException e)
            {
                System.out.println("Menu controller "+e.getMessage());
            }
    }
      else if(btnText.equalsIgnoreCase("display product"))
    {
            displayProductController = new DisplayProductController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            try
            {
            displayProductController.launchcontroller(stg, brand_lable.getText());
            }
            catch(IOException e)
            {
                System.out.println("Menu controller "+e.getMessage());
            }
    }
    
}
}