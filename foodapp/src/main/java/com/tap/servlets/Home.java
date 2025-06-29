package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DaoImplementation.RestaurantImp;
import domain.Restaurant;


@WebServlet("/home")
public class Home extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RestaurantImp res=new RestaurantImp();
List<Restaurant> allRestaurant = res.getAllRestaurant();
System.out.println("home");
req.setAttribute("allRestaurant", allRestaurant);
	RequestDispatcher d = req.getRequestDispatcher("Home.jsp");
		d.forward(req, resp);

		
	}

}
