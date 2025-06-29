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

import DaoImplementation.OrderImp;
import domain.Cartitem;
import domain.OrderHistory;
import domain.Users;

@WebServlet("/checkout")
public class Checkoutservlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = req.getParameter("address");
		String payment = req.getParameter("payentmode");
String parameter = req.getParameter("totalAmount");
System.out.println(parameter);
req.setAttribute("parameter", parameter);
String parameter2 = req.getParameter("totalAmount");
req.setAttribute("parameter2", parameter2);
	RequestDispatcher d = req.getRequestDispatcher("checkout.jsp");
	d.forward(req, resp);
	
		
	} 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
