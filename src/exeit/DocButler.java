/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author GDZC0003
 */
public class DocButler extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root,600, 450);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        */
        
        createMenu(primaryStage);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void createMenu(Stage primaryStage){
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 900, 600, Color.WHITE);
        
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);
        
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,new SeparatorMenuItem(), exitMenuItem);
        
        menuBar.getMenus().addAll(fileMenu);
        
        
        
        createTree(primaryStage,root);
        createTextarea(root);
        primaryStage.setScene(scene);
        
        
        
    }
    
    public void createTree(Stage primaryStage, BorderPane root){           
        
        TreeItem<String> rootItem = new TreeItem<> ("Inbox");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }        
        TreeView<String> tree = new TreeView<String> (rootItem); 
        root.setLeft(tree);
    }
    
    public void createTextarea(BorderPane root){
        TextArea t=new TextArea();
        root.setCenter(t);
    }
}
