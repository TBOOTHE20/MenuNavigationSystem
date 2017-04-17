/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

import java.io.InputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
        Scene scene = new Scene(sp, 600, 500);
        this.setTitle("Dish View");
        this.setScene(scene);
       
    }
   
    public void save()
    {
        this.close();
        //for debugging purpose
        
    }
    
    public void resetinfo()
    {
      System.out.println("I will go to item " + count+"and display info on"+arrD.get(count).name);
  
      
      final String resourcePath = "rsc/" + arrD.get(count).image;
       
        //double checking the string was created with the correct path
        System.out.println(resourcePath);
       
        //Read from input stream and getClassLoader looks also outside of menunavsys folder
      InputStream stream = DishStage.class.getClassLoader().getResourceAsStream(resourcePath);

      //Put the resource path  actually image into image container
      Image img =  new Image(stream);
               
      
        this.lblname.setText(arrD.get(count).name);
        this.lbldescription.setText(arrD.get(count).description);
        this.lblprice.setText(arrD.get(count).price);
        this.theimageview.setImage(img);
        
       
    
    }
   
    public void initdishscreen()
    {
        System.out.println("I'm creating a screen and will go to item " + count+"and display"+arrD.get(count).name);
                 
        System.out.println("I created the path for " + arrD.get(count).image);
        
        final String resourcePath = "/rsc/" + arrD.get(count).image;
        
        //double checking the string was created with the correct path
        System.out.println(resourcePath);
       
        
        this.lblname = new Label(arrD.get(count).name);
        this.lbldescription = new Label(arrD.get(count).description);
        this.lblprice = new Label(arrD.get(count).price);
        this.theimageview = new ImageView();
        
        gp.add(lblname,0,0);
        gp.add(lbldescription,1,0);
        gp.add(lblprice,0,1);
        gp.add(theimageview, 0,2);
       
       
        Button btnPrev = new Button();
       btnPrev.setText("Prev");
       gp.add(btnPrev,0,3);
       
       btnPrev.setOnAction(new EventHandler<ActionEvent>() 
       {            
                @Override
                public void handle(ActionEvent event) 
                {
                    if(count ==0)
                    {
                        System.out.println("Clear");
                        System.out.println("The Prev button press so go to item" + count);
                        resetinfo();
                    
                    }
                    
                    else
                    {
                        count = count-1;
                       System.out.println("The Prev button press so go to item" + count);
                       resetinfo();
                       
                    }
                }
            });
       
       
        Button btnNext = new Button();
       btnNext.setText("Next");
       gp.add(btnNext,1,3);
       
       btnNext.setOnAction(new EventHandler<ActionEvent>() 
       {            
                @Override
                public void handle(ActionEvent event) 
                {
                    if(count <3)
                    {
                        count++;
                    System.out.println("The Next button press so go to item" + count);
                         resetinfo();
                    
                    }
                    
                    else
                    {
                    
                       count = 0;
                       System.out.println("The Next button press so go to item" + count);
                        resetinfo();
                       
                    }
                }
            });
    this.resetinfo();
    
    }
    
    
    //data members
    protected ArrayList<Dish> arrD;
    protected ScrollPane sp;
    protected GridPane gp;
    static DishStage instance = null;
    
   int i =0;
   int count = 0;
   Label lblname ;
   Label lbldescription ;
   Label lblprice;
   ImageView theimageview;
   
   
}

