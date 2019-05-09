package za.ac.tut.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.model.entity.Staff;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-15T04:25:18")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile SingularAttribute<Staff, String> password;
    public static volatile SingularAttribute<Staff, Staff> manager;
    public static volatile SingularAttribute<Staff, String> surname;
    public static volatile SingularAttribute<Staff, String> name;
    public static volatile SingularAttribute<Staff, Boolean> isOnDuty;
    public static volatile SingularAttribute<Staff, Long> id;

}