/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.model.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bean.StudentOrderFacadeLocal;
import za.ac.tut.model.business.Utility;
import za.ac.tut.model.entity.StudentOrder;

/**
 *
 * @author Evin
 */
public class ShowAvailableOrderServlet extends HttpServlet {
    @EJB
    private StudentOrderFacadeLocal studentOrderFacade;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<StudentOrder> orders = studentOrderFacade.findAll();
        List<StudentOrder> availOrders = Utility.getAvailOrders(orders);
        
        HttpSession sess = request.getSession();
        sess.setAttribute("availOrders", availOrders);
        
        String url = "showAvailOrders.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

   
}
