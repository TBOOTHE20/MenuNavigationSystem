/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

import static java.lang.reflect.Array.get;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sun.applet.Main;

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
   int count = 0;
   Label lblname ;
   Label lbldescription ;
   Label lblprice;
   
    public void save()
    {
        this.close();
        //for debugging purpose
        
    }
   
    public void refresh()
    {
        //ImageView Image = new ImageView(new Image(getClass().getResourceAsStream("/ribeye.jpeg")));
        //System.out.println("I got the first"+arrD.get(0).name);
      /*  final ImageView imv = new ImageView();
        final Image image2 = new Image(Main.class.getResourceAsStream("/cheesecake.jpg"));
        imv.setImage(image2);
        final HBox pictureregion = new HBox();
        
        pictureregion.getChildren().add(imv);
     
        
       */
        
        System.out.println("I'm in refresh so go to item " + count+"and display"+arrD.get(count).name);
        
        lblname = new Label(arrD.get(count).name);
        lbldescription = new Label(arrD.get(count).description);
        lblprice = new Label(arrD.get(count).price);
        
        gp.add(lblname,0,0);
        gp.add(lbldescription,1,0);
        gp.add(lblprice,1,1);
          //gp.add(pictureregion, 0,1);
       
       
        Button btnPrev = new Button();
       btnPrev.setText("Prev");
       gp.add(btnPrev,0,2);
       
       btnPrev.setOnAction(new EventHandler<ActionEvent>() 
       {            
                @Override
                public void handle(ActionEvent event) 
                {
                    if(count ==0)
                    {
                        System.out.println("Clear");
                        System.out.println("The Prev button press so go to item" + count);
                        refresh();
                    
                    }
                    
                    else
                    {
                        count = count-1;
                       System.out.println("The Prev button press so go to item" + count);
                       refresh();
                       
                    }
                }
            });
       
       
        Button btnNext = new Button();
       btnNext.setText("Next");
       gp.add(btnNext,1,2);
       
       btnNext.setOnAction(new EventHandler<ActionEvent>() 
       {            
                @Override
                public void handle(ActionEvent event) 
                {
                    if(count <3)
                    {
                        count++;
                    System.out.println("The Next button press so go to item" + count);
                        refresh();
                    
                    }
                    
                    else
                    {
                    
                       count = 0;
                       System.out.println("The Next button press so go to item" + count);
                       refresh();
                       
                    }
                }
            });
    
    
    }
    
    
    //data members
    protected ArrayList<Dish> arrD;
    protected ScrollPane sp;
    protected GridPane gp;
    static DishStage instance = null;
}
