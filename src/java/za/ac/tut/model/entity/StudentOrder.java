/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Evin
 */
@Entity
public class StudentOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private String description;
    private double amount;
    private boolean ready;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Student student;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Staff orderManager;
    @OneToMany(cascade = CascadeType.PERSIST, targetEntity = Item.class)
    private List<Item> items;

    public StudentOrder() {
    }

    public StudentOrder(double amount, boolean ready, Student student, Staff orderManager, List<Item> items) {
        this.amount = amount;
        this.ready = ready;
        this.student = student;
        this.orderManager = orderManager;
        this.items = items;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Staff getOrderManager() {
        return orderManager;
    }

    public void setOrderManager(Staff orderManager) {
        this.orderManager = orderManager;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItem(List<Item> item) {
        this.items = items;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentOrder)) {
            return false;
        }
        StudentOrder other = (StudentOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String orderSummary = "<table>"
                            + "<tr><td>"+"Order #"+id+"</td></tr>";
        double totPrice = 0.0;
        String itemDescriptions = "";
//        for(int i=0; i<items.size(); i++){
//            itemDescriptions += "<tr><td>"+(i+1)+" "+items.get(i).getDescription()+"</td></tr>";
//            totPrice+=items.get(i).getPrice();
//        }
        orderSummary += itemDescriptions
                     +"<tr><td>"+"Total price: R"+totPrice+"</td></tr>"
                     +"</table>";
        
        return  orderSummary;
    }
    
}
