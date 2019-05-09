<%-- 
    Document   : showAvailOrders
    Created on : 14 May 2017, 4:09:02 AM
    Author     : Evin
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.StudentOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Orders</title>
    </head>
    <%
        List<StudentOrder> availOrders = (List<StudentOrder>)session.getAttribute("availOrders");
       String message = "";
        if(availOrders.isEmpty()){
            message = "<tr><td>" 
                    + "Please wait patiently as we process your order"
                    + "</td></tr>";
        }
        else{
            for(int i=0; i<availOrders.size(); i++){
                message += "<tr>"
                        +"td"+availOrders.get(i).toString()+"</td>"
                        +"</tr>";
            }
        }
    %>
    <body>
        <h1>Orders currently available:</h1>
       
        <table border="2" width="4" cellspacing="1" cellpadding="1">
           <%=message %>
        </table>

    </body>
</html>
