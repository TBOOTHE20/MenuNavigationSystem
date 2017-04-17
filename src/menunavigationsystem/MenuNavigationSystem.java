/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
        //1. Prepare by finding the file
        java.io.File file = new java.io.File("config.txt"); //get config file and put it in file
        
        int ctr =0;
        //Dish [] arrDi = {};
        //= new Dish[ctr]; // make an array the length of the file
        ArrayList<Dish> myListofDishes = new ArrayList();      
        try
        {   //use a scanner that will read from file
            Scanner input = new Scanner (file); 
            while (input.hasNext())
            {
                String num = input.nextLine();
                System.out.println(num);
                ctr = ctr +1; //count how many lines in the file
            }
            
            Scanner input2 = new Scanner (file); 
            int i =0;
            while(input2.hasNext())
            {
                String num2 = input2.nextLine();
                String parts[]= num2.split(": "); //cut off info type
                String n = parts[1]; //get second part after :
                System.out.println("the name is "+ n); //check
                
                String num3 =input2.nextLine();
                String parts3[]=num3.split(": ");
                String d = parts3[1];
                System.out.println("The description is "+d);
                
                String num4 =input2.nextLine();
                String parts4[]=num4.split(": ");
                String p = parts4[1];
                System.out.println("The price is "+p);
                
                String num5 =input2.nextLine();
                String parts5[]=num5.split(": ");
                String im = parts5[1];
                System.out.println("The image is "+im);
                
                Dish plate1 = new Dish(n,d,p,im);//create the dish object
                 
                System.out.println(plate1.price);//check dish object stuff there
                
                //add to array
                myListofDishes.add(plate1);
                
                System.out.println("Im in there");
               
                
            }
            
           
                
        }
        catch(Exception e)
        {
            System.out.println("Did not read file2\n");
        }
        
        
        Button btn = new Button();
        btn.setText("Dish Options");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
                DishStage ds = new DishStage(myListofDishes);
                ds.initdishscreen();
                ds.showAndWait();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Smart Restaurant");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        System.out.println("Hi");
        
        for (int y =0; y < myListofDishes.size(); y++)
        {
          System.out.println(myListofDishes.get(y).name);
        
        }
        
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
