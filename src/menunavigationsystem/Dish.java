/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menunavigationsystem;

/**
 *
 * @author csc190
 */
public class Dish {
    public Dish(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.price = price;
        
    }
    protected String name;
    protected String description;
    protected int price;
}
