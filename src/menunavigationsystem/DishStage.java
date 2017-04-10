/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

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
    
   public DishStage()
   {
        sp = new ScrollPane();
        gp = new GridPane();
        
        sp.setContent(gp);
        instance = this;
        Scene scene = new Scene(sp, 300, 500);
        this.setTitle("Dish View");
        this.setScene(scene);
       
    }
   
    public void save()
    {
        this.close();
        //for debugging purpose
        
    }
   
    public void refresh()
    {/*
        for(int i=0; i<arrEm.length; i++){
            Employee em = arrEm[i];
            Label lbl = new Label(em.name);
            Button btn = new Button();
            btn.setText("Edit");
            btn.setOnAction(new EventHandler<ActionEvent>() {            
                @Override
                public void handle(ActionEvent event) {
                    EmployeeForm ef = new EmployeeForm(em);
                    ef.showAndWait();
                }
            });
            gp.add(lbl, 0, i);
            gp.add(btn, 1, i); 
        }
         Button btnSave = new Button();
        btnSave.setText("Save");
         btnSave.setOnAction(new EventHandler<ActionEvent>() {            
                @Override
                public void handle(ActionEvent event) {
                    save();
                    print();
                }
            });
        gp.add(btnSave, 1, arrEm.length);
    */ 
       Button btnCheck = new Button();
       btnCheck.setText("Connect");
       gp.add(btnCheck,0,0);
       
        Button btnPrev = new Button();
       btnPrev.setText("Prev");
       gp.add(btnPrev,0,3);
       
        Button btnNext = new Button();
       btnNext.setText("Next");
       gp.add(btnNext,1,3);
    
    
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
    protected Dish[] arrD;
    protected ScrollPane sp;
    protected GridPane gp;
    static DishStage instance = null;
}
