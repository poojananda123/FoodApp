package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Additem extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String[] items = req.getParameterValues("item");
	        
	        // Process the items as needed
	        if (items != null) {
	            // Do something with the items
	            for (String item : items) {
	                System.out.println("Item: " + item);
	            }
	        }
	        resp.sendRedirect("/Cart");
	}

}

