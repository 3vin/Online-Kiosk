/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.model.entity.Staff;

/**
 *
 * @author Sakekile Mazwi
 */
@Stateless
public class StaffFacade extends AbstractFacade<Staff> implements StaffFacadeLocal {
    @PersistenceContext(unitName = "KioskWebApp3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffFacade() {
        super(Staff.class);
    }
    
}
