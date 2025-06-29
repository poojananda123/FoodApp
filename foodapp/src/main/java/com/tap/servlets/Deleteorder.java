package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.OrderImp;
@WebServlet("/delete-orders-range")
public class Deleteorder extends HttpServlet {
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  String orderIdStr = request.getParameter("orderId");

	        if (orderIdStr == null || orderIdStr.isEmpty()) {
	            response.sendRedirect("order-history.jsp?msg=Missing+Order+ID");
	            return;
	        }

	        try {
	            int orderId = Integer.parseInt(orderIdStr);
	            OrderImp dao = new OrderImp();
	            boolean success = dao.deleteOrderById(orderId);

	            if (success) {
	                response.sendRedirect("order-history");
	            } else {
	                response.sendRedirect("order-history.jsp?msg=Failed+to+delete+order");
	            }

	        } catch (NumberFormatException e) {
	            response.sendRedirect("order-history.jsp?msg=Invalid+Order+ID");
	        }
	    }
}
