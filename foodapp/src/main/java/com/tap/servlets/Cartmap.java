package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImplementation.MenuImp1;
import domain.Cartitem;

public class Cartmap extends HttpServlet  {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve item details from the request parameters
	    int itemId = Integer.parseInt(request.getParameter("itemId"));
	    String itemName = request.getParameter("itemName");
	    int price = Integer.parseInt(request.getParameter("price"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    
	    // Create a new CartItem object with the retrieved details
	    Cartitem cartItem = new Cartitem(itemId, itemName, price, quantity, quantity, quantity, quantity, itemName);
	    
	    // Get the HttpSession object
	    HttpSession session = request.getSession(true);
	    
	    // Retrieve the list of cart items from the session, or create a new list if it doesn't exist
	    List<Cartitem> cartItems = (List<Cartitem>) session.getAttribute("cartItems");
	    if (cartItems == null) {
	        cartItems = new ArrayList<>();
	    }
	    
	    // Add the new cart item to the list
	    cartItems.add(cartItem);
	    
	    // Store the updated list of cart items back into the session
	    session.setAttribute("cartItems", cartItems);
	    
	    // Redirect back to the menu page
	    response.sendRedirect("menu");
	}

}