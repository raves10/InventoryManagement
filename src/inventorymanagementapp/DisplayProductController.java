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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class DisplayProductController {
    
 
    private Parent parent;
    private Scene scene;
    private Stage stage;
@FXML
private Label displaybrand;

private Mediator mediator;
private LinkedHashMap<String,ProductDetails> prodMap;
private int prodId;
private MenuController menuController;

//Table View
    @FXML
    TableView<ProductDetails> table = new TableView<>();

    //Table Columns
    @FXML
    TableColumn<ProductDetails, String> name;
    @FXML
    TableColumn<ProductDetails, Integer> count;
    @FXML
    TableColumn<ProductDetails, Double> price;
    @FXML
    TableColumn<ProductDetails, String> desc;
//Constructor
    public DisplayProductController() {

        //fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/DisplayProduct.fxml"));
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
       
        this.stage.setTitle(brandSelection +" Display Products");
        this.stage.setScene(scene);
        System.out.println("88888"+displaybrand);
        
        displaybrand.setText(brandSelection);
        this.stage.setResizable(false);
        mediator = new Mediator();
        
        ObservableList<ProductDetails> products = FXCollections.observableArrayList(mediator.getProductList(displaybrand.getText()
        ));
        
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
            count.setCellValueFactory(
                new PropertyValueFactory<>("count"));
            price.setCellValueFactory(
                new PropertyValueFactory<>("price"));
            desc.setCellValueFactory(
                new PropertyValueFactory<>("description"));
          table.setItems(products);
        this.stage.show();
    }
    
    
    
    @FXML
    public void handleButton(ActionEvent event) throws Exception
    {
        String btnText = ((Button) event.getSource()).getText();
         if (btnText.equalsIgnoreCase("Back"))
        {
            menuController = new MenuController();
            Stage stg = new Stage();
            System.out.println("stage1"+this.stage);
            menuController.launchcontroller(stg, displaybrand.getText());
        }
    }
    
}

