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
import za.ac.tut.model.bean.StudentFacadeLocal;
import za.ac.tut.model.business.Utility;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Evin
 */
public class StudentLoginServlet extends HttpServlet {
    @EJB
    private StudentFacadeLocal studentFacade;

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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        List<Student> students = studentFacade.findAll();
        
        Student stud = Utility.findStudent(name, password, students);
        HttpSession sess = request.getSession();
        sess.setAttribute("login", stud);
         
        String url ="menu.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }


}
