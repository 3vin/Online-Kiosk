/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.model.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bean.StaffFacadeLocal;
import za.ac.tut.model.bean.StudentOrderFacadeLocal;
import za.ac.tut.model.business.Cart;
import za.ac.tut.model.business.Utility;
import za.ac.tut.model.entity.Item;
import za.ac.tut.model.entity.Staff;
import za.ac.tut.model.entity.Student;
import za.ac.tut.model.entity.StudentOrder;

/**
 *
 * @author Evin
 */
public class CreateOrderServlet extends HttpServlet {
    @EJB
    private StudentOrderFacadeLocal studentOrderFacade;
    @EJB
    private StaffFacadeLocal staffFacade;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sess = request.getSession();
        Student student = (Student) request.getAttribute("loggedStud");
        Cart cart = (Cart) request.getAttribute("cart");
        StudentOrder order = null;
        if(cart==null && student==null){
            student = new Student();
            cart = new Cart();            
        }
        if(student!=null){
            
            List<Item> items = cart.getItems();
            if(items.isEmpty()!=true || items!=null){
                List<Staff> staff = staffFacade.findAll();
                Staff orderManager = Utility.getOrderManager(staff);
                order = new StudentOrder(cart.getTotalPrice(), true, student, orderManager, items);
                studentOrderFacade.create(order);
            }
        }
        else{
            student = new Student();
        }  
        
        sess.setAttribute("order", order);
        String url ="createOrder.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
