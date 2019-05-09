package za.ac.tut.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.model.entity.Item;
import za.ac.tut.model.entity.Staff;
import za.ac.tut.model.entity.Student;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-15T04:25:18")
@StaticMetamodel(StudentOrder.class)
public class StudentOrder_ { 

    public static volatile SingularAttribute<StudentOrder, Double> amount;
    public static volatile SingularAttribute<StudentOrder, Student> student;
    public static volatile SingularAttribute<StudentOrder, Boolean> ready;
    public static volatile SingularAttribute<StudentOrder, Staff> orderManager;
    public static volatile SingularAttribute<StudentOrder, Long> id;
    public static volatile ListAttribute<StudentOrder, Item> items;

}