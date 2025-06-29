package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DaoImplementation.CartImp;
import DaoImplementation.MenuImp1;
import DaoImplementation.RestaurantImp;
import domain.Cartitem;
import domain.Menu;
import domain.Restaurant;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        CartImp cartImp = new CartImp();
        List<Cartitem> cartItemList = cartImp.getCartItemsByUserId(userId);
        double totalPrice = cartItemList.stream()
                .mapToDouble(c -> c.getPrice() * c.getQuantity())
                .sum();

        req.setAttribute("cartItemList", cartItemList);
        req.setAttribute("totalPrice", totalPrice);

        RequestDispatcher dispatcher = req.getRequestDispatcher("Cart.jsp");
        dispatcher.forward(req, resp);
    }
}