/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bean;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.StudentOrder;

/**
 *
 * @author Sakekile Mazwi
 */
@Local
public interface StudentOrderFacadeLocal {

    void create(StudentOrder studentOrder);

    void edit(StudentOrder studentOrder);

    void remove(StudentOrder studentOrder);

    StudentOrder find(Object id);

    List<StudentOrder> findAll();

    List<StudentOrder> findRange(int[] range);

    int count();
    
}
