package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImplementation.OrderImp;
import domain.Order;
@WebServlet("/order-history")
public class OrderHistory extends HttpServlet {
	
	
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        HttpSession session = req.getSession(false);
	        if (session == null || session.getAttribute("userId") == null) {
	            resp.sendRedirect("login.jsp");
	            return;
	        }

	        int userId = (int) session.getAttribute("userId");
	        OrderImp orderDao = new OrderImp();
	        List<Order> orders = orderDao.getOrdersByUserId(userId);

	        req.setAttribute("orders", orders);
	        RequestDispatcher rd = req.getRequestDispatcher("orderhis.jsp");
	        rd.forward(req, resp);
	    }
	}



