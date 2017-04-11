/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author csc190
 */
public class DishStage extends Stage {
    
   public DishStage(ArrayList<Dish> myListofDishes)
   {
        this.arrD =myListofDishes;
        sp = new ScrollPane();
        gp = new GridPane();
        
        sp.setContent(gp);
        instance = this;
        Scene scene = new Scene(sp, 300, 500);
        this.setTitle("Dish View");
        this.setScene(scene);
       
    }
   
   int i =0;
   
    public void save()
    {
        this.close();
        //for debugging purpose
        
    }
   
    public void refresh()
    {
        
        /*Dish di = arrD[0];
        System.out.println("psst"+di.name);
        Label lblname = new Label(di.name);
        Label lbldescription = new Label(di.description);
        Label lblprice = new Label(di.price);
        
        gp.add(lblname,0,0);*/
        
        //System.out.println("I got the first"+arrD.get(0).name);
        int count = 0;
        Label lblname = new Label(arrD.get(count).name);
        Label lbldescription = new Label(arrD.get(count).description);
        Label lblprice = new Label(arrD.get(count).price);
        
        gp.add(lblname,0,0);
        gp.add(lbldescription,1,0);
        gp.add(lblprice,1,1);
       
       
        Button btnPrev = new Button();
       btnPrev.setText("Prev");
       gp.add(btnPrev,0,2);
       
        Button btnNext = new Button();
       btnNext.setText("Next");
       gp.add(btnNext,1,2);
    
    
    }
    
    /*
    public void print()
    {
        for(int i=0; i<this.arrEm.length; i++){
            Employee ep = arrEm[i];
            System.out.println("Name: " + ep.name + ", Age: " + String.valueOf(ep.age));
        }
    }*/
    //data members
    protected ArrayList<Dish> arrD;
    protected ScrollPane sp;
    protected GridPane gp;
    static DishStage instance = null;
}
