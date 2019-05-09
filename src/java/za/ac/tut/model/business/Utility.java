/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.model.business;

import java.util.ArrayList;
import java.util.List;
import za.ac.tut.model.entity.Item;
import za.ac.tut.model.entity.Staff;
import za.ac.tut.model.entity.Student;
import za.ac.tut.model.entity.StudentOrder;

/**
 *
 * @author Evin
 */
public class Utility {

    public static List<StudentOrder> getAvailOrders(List<StudentOrder> orders) {
        List<StudentOrder> availOrders = new ArrayList<>();
        if(orders == null){
            orders = new ArrayList<>();
        }
        for(int i =0; i<orders.size(); i++){
            if(orders.get(i).isReady()){
                availOrders.add(orders.get(i));
            }
        }     
      return availOrders;
    }

   
    public static Student findStudent(String name, String password, List<Student> students) {
        Student foundStudent = null;
        for(int i=0; i<students.size();i++){
            if(students.get(i).getName().equalsIgnoreCase(name) 
            && students.get(i).getPassword().equals(password)){
                foundStudent = students.get(i);
            }
        }
      return foundStudent;
    }

    public static Staff getOrderManager(List<Staff> staff) {
        Staff orderManager = new Staff();
        for(int i=0; i<staff.size();i++){
            if(staff.get(i).isIsOnDuty()){
                orderManager = staff.get(i);
            }
        }
      return orderManager;
    }

    public static List<Item> generateItemsList(int quantity,Item item) {
        List<Item> items = new ArrayList<>();
        for(int i=0; i<quantity;i++){
            items.add(i,item);
        }
      return items;
    }

    public static List<Item> generateRemovedItemsList(int quantity, Item item, List<Item> cartItems) {
        for(int i=0; i<quantity;i++){
            cartItems.remove(item);
        }
      return cartItems;
    }

    public static Staff findStaff(String name, String password, List<Staff> staff) {
        Staff foundStaffMember = null;
        for(int i=0; i<staff.size();i++){
            if(staff.get(i).getName().equalsIgnoreCase(name) 
            && staff.get(i).getPassword().equals(password)){
                foundStaffMember = staff.get(i);
            }
        }
      return foundStaffMember; 
    }

    public static boolean confirmPassword(String pass,String confPass){
        if(pass.equals(confPass)){
          return true;  
        }
     return false;
    }

    public static Item findItem(Long id,List<Item> items){
        Item item = new Item();
            for(int i=0;i<items.size();i++){
                if(items.get(i).getId() == id){
                    item = items.get(i);
                }
            }
      return item;
    }
    
    public static List<Item> fakeDB(){
        List<Item> items = new ArrayList<>();
        items.add(new Item((long)1,"Chips, Russian & Becon",20.00,true));
        items.add(new Item((long)2,"Chips & Russian",15.00,true));
        items.add(new Item((long)3,"Chips & Russian, Palony",15.00,true));
        items.add(new Item((long)4,"Ribs, Cheese & Chips",30.000,true));
        items.add(new Item((long)5,"Small Chips with Source",15.00,true));
        items.add(new Item((long)6,"Medium Chips with Source",20.00,true));
        items.add(new Item((long)7,"Large Chips with Source",25.00,true));
        
      return items;
    }

    public static Cart addToCart(List<Item> items, List<Item> cartItems) {
        Cart cart = new Cart();
        for(int i=0; i<items.size();i++){
            cartItems.add(items.get(i));
        }
        cart.setItems(cartItems);
      return cart;
    }
}
