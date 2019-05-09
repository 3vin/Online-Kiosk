/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.model.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import za.ac.tut.model.entity.Item;

/**
 *
 * @author Evin
 */
public class Cart implements Serializable{
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> itemList) {
        this.items = itemList;
    }
    
    public void addToCart(Item item){
        items.add(item);
    }
    
    public void removeItem(Item item){
        items.remove(item);
    }
    
    public int getNoOfItems(){
      return items.size();
    } 
    public double getTotalPrice(){
        double totPrice = 0.0;
        for(int i=0; i<items.size(); i++){
            totPrice += items.get(i).getPrice();
        }
        
      return totPrice;
    }
    public String viewCart(){
        String contents ="";
        if(items.isEmpty()){
          contents = "Cart is empty.";  
        }else
            if(items==null || items.size()<1){
                contents = "Cart is empty.";
            }
        else{ 
            contents += "<table>";
            for(int i=0; i<items.size(); i++){
             contents += "<tr>"
                       + "<td>"+"Item #"+items.get(i).getId()+"</td>"
                       + "<td>"+items.get(i).getDescription()+"</td>"
                       + "<td>"+" R"+items.get(i).getPrice()+"</td>"
                       + "</tr>";
            }
            contents += "<tr><td>"+"Total Price: "+getTotalPrice()+"</td></tr>"
                      + "</table>";
        }
        
      return contents;
    }
    public int updateQuantity(long id){
        int quantity=0;
        List<Item> is = getItems();
        for(int i=0;i<is.size();i++){
            if(is.get(i).getId() == id){
                quantity++;
            }
        }
        
        
      return quantity;
    }
}
