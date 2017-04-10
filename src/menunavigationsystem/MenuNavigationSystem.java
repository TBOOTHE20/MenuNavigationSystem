/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class MenuNavigationSystem extends Application {
    
    protected Scanner x;
    
    @Override
    public void start(Stage primaryStage) 
    {
        //1. Prepare data to be read from file
        
        java.io.File file = new java.io.File("config.txt");
        
        try
        {
            Scanner input = new Scanner (file);
            while (input.hasNext())
            {
            String num = input.nextLine();
            System.out.println(num);
            }
        }
        catch(Exception e)
        {
            System.out.println("Did not read file\n");
        }
        
        
        Button btn = new Button();
        btn.setText("Dish Options");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                DishStage ds = new DishStage();
                ds.refresh();
                ds.showAndWait();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Smart Restaurant");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
