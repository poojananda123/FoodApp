package com.tap.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImplementation.AddressImp;
import DaoImplementation.OrderImp;
import DaoImplementation.OrderImple2;
import DaoInterface.AddressDao;
import DaoInterface.OrderDao;
import domain.Address;
import domain.Order;
@WebServlet("/place-order")
public class Orderserv  extends HttpServlet{
//	 @Override
//	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	        // ✅ Validate session
//	        HttpSession session = req.getSession(false);
//	        if (session == null || session.getAttribute("userId") == null) {
//	            resp.sendRedirect("login.jsp");
//	            return;
//	        }
//	        String address = req.getParameter("address");
//	        String city = req.getParameter("city");
//	        String zip = req.getParameter("zip");
//
//	        // Optionally store in Order object or pass directly
//	        req.setAttribute("address", address);
//	        req.setAttribute("city", city);
//	        req.setAttribute("zip", zip);
//	        try {
//	            // ✅ Get required data
//	        	int userId = (int) session.getAttribute("userId");
//
//	            // ❗These can throw NumberFormatException if null or not numeric
//	            int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
//	            double totalAmountDouble = Double.parseDouble(req.getParameter("totalAmount"));
//	            int totalAmount = (int) totalAmountDouble;
//
//	            String paymentMode = req.getParameter("paymentMode");
//	            String status = "Pending";
//
//	            // ✅ Create Order object
//	            Date orderDate = new Date(System.currentTimeMillis());
//	            Order order = new Order();
//	            order.setUserId(userId);
//	            order.setRestaurantId(restaurantId);
//	            order.setOrderDate(orderDate);
//	            order.setTotalAmount(totalAmount);
//	            order.setStatus(status);
//	            order.setPaymentmode(paymentMode);
//
//	            // ✅ Save order and get generated ID
//	            OrderImp orderDao = new OrderImp();
//	            orderDao.saveOrder(order); // this sets orderId internally
//
//	            // ✅ Set order in request scope and forward
//	            req.setAttribute("order", order);
//	            RequestDispatcher dispatcher = req.getRequestDispatcher("order.jsp");
//	            dispatcher.forward(req, resp);
//
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            req.setAttribute("errorMessage", "Failed to place order.");
//	            req.getRequestDispatcher("error.jsp").forward(req, resp);
//	        }
//	    }
//	 @Override
//	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	     resp.sendRedirect("order.jsp"); // or show an error page
//	 }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession(false);
	    int userId = (int) session.getAttribute("userId");

	    String addr = req.getParameter("address");
	    String city = req.getParameter("city");
	    String zip = req.getParameter("zip");
	    String paymentMode = req.getParameter("paymentMode");
	    double totalAmount = Double.parseDouble(req.getParameter("totalAmount"));
	    int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
String rname = req.getParameter("restaurantNmae");
	    // Save address
	    Address address = new Address();
	    address.setUserId(userId);
	    address.setAddress(addr);
	    address.setCity(city);
	    address.setZip(zip);

	    AddressImp addressDao = new AddressImp();
	    int addressId = addressDao.saveAddress(address);

	    // Save order
	    Order order = new Order();
	    order.setUserId(userId);
	    order.setRestaurantId(restaurantId);
	    order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));
	    order.setTotalAmount((int) totalAmount);
	    order.setStatus("Confirmed");
	    order.setPaymentmode(paymentMode);
	    order.setAddressId(addressId); // if normalized
	  order.setRestaurantName(rname);
	    OrderImp orderDao = new OrderImp();
	    orderDao.saveOrder(order);
	    
	    // this now works, no circular FK
	   
	    
	    req.setAttribute("order", order);
	    req.setAttribute("address", addr);
	    req.setAttribute("city", city);
	    req.setAttribute("zip", zip);

	    RequestDispatcher rd = req.getRequestDispatcher("order.jsp");
	    rd.forward(req, resp);
	}
	

} 