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
import za.ac.tut.model.bean.ItemFacadeLocal;
import za.ac.tut.model.business.Cart;
import za.ac.tut.model.entity.Item;
import za.ac.tut.model.business.Utility;
/**
 *
 * @author Evin
 */
public class AddToCartServlet extends HttpServlet {
    @EJB
    private ItemFacadeLocal itemFacade;
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
        Cart cart = (Cart) sess.getAttribute("cart");
        
        if(cart==null){
           cart = new Cart();
       }
        long itemNo = Long.parseLong(request.getParameter("item#"));
        int quantity = Integer.parseInt(request.getParameter("qty"));
      
        //Item item = itemFacade.find(itemNo);
        
        List<Item> dbItems = Utility.fakeDB();
        Item item = Utility.findItem(itemNo, dbItems);
        if(item == null){
            item = new Item();
        }
       
       List<Item> cartItems = cart.getItems();
       List<Item> items = Utility.generateItemsList(quantity,item);
       if(cart.getItems().isEmpty()){
           cart.setItems(items);
       }
       else{
           cart = Utility.addToCart(items,cartItems);
       }
        
        sess.setAttribute("cart", cart);
                
        String url = "viewOrder.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

}
