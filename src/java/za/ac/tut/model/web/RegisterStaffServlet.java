/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.model.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bean.StaffFacadeLocal;
import za.ac.tut.model.entity.Staff;

/**
 *
 * @author Evin
 */
public class RegisterStaffServlet extends HttpServlet {
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
        
        String studNo = request.getParameter("studNo");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNo = request.getParameter("phoneNo");
        String password = request.getParameter("password");
        
        Staff manager = staffFacade.find(1);
        if(manager == null){
            long managerId = 1;
            manager = new Staff(managerId, name, surname, password);
        }
        Staff staff = new Staff(name, surname, password, manager);
        staffFacade.create(staff);
        
        String url ="createOrder.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

}
