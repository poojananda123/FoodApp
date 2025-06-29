package com.tap.servlets;



import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DaoImplementation.CartImp;
import DaoImplementation.MenuImp1;
import domain.Cartitem;
import domain.Menu;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");

        try {
            int menuId = Integer.parseInt(req.getParameter("menuId"));
            int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));

            MenuImp1 menuDao = new MenuImp1();
            Menu menu = menuDao.getMenuById(menuId); // ✅ you must implement this if not present

            if (menu == null) {
                resp.sendRedirect("error.jsp"); // menu not found
                return;
            }

            Cartitem item = new Cartitem();
            item.setUserId(userId);
            item.setMenuId(menuId);
            item.setRestaurantId(restaurantId);
            item.setItemname(menu.getItemname());
            item.setPrice(menu.getPrice());
            item.setQuantity(1); // default quantity
            item.setRestaurantName("Restaurant"); // Replace with actual restaurant name if available

            CartImp cartDao = new CartImp();
            cartDao.saveCartItem(item);

            resp.sendRedirect("cart"); // redirect to view cart
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}

