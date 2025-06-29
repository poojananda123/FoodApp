package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImplementation.CartImp;
import DaoImplementation.MenuImp1;
import DaoImplementation.RestaurantImp;
import domain.Cartitem;
import domain.Menu;
import domain.Restaurant;
@WebServlet("/add-to-cart")
public class Updateserv extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        HttpSession session = req.getSession(false);
	        if (session == null || session.getAttribute("userId") == null) {
	            resp.sendRedirect("login.jsp");
	            return;
	        }

	        int userId = (int) session.getAttribute("userId");
	        String menuIdStr = req.getParameter("menuId");
	        String action = req.getParameter("action");
	        String restaurantIdStr = req.getParameter("restaurantId");

	        CartImp cartImp = new CartImp();

	        if (menuIdStr != null && action != null && restaurantIdStr != null) {
	            try {
	                int menuId = Integer.parseInt(menuIdStr.trim());
	                int restaurantId = Integer.parseInt(restaurantIdStr.trim());

	                Cartitem item = cartImp.getCartItemByMenuIdAndUserId(menuId, userId, restaurantId);

	                if (item != null) {
	                    if ("add".equals(action)) {
	                        item.setQuantity(item.getQuantity() + 1);
	                        cartImp.updateCartItem(item);
	                    } else if ("remove".equals(action)) {
	                        if (item.getQuantity() > 1) {
	                            item.setQuantity(item.getQuantity() - 1);
	                            cartImp.updateCartItem(item);
	                        } else {
	                            cartImp.deleteCartItemById(item.getCartId());
	                        }
	                    }
	                } else if ("add".equals(action)) {
	                    MenuImp1 menuImp = new MenuImp1();
	                    Menu menu = menuImp.getMenuById(menuId);

	                    RestaurantImp restaurantImp = new RestaurantImp();
	                    Restaurant restaurant = restaurantImp.getRestaurant(restaurantId);

	                    Cartitem newItem = new Cartitem();
	                    newItem.setUserId(userId);
	                    newItem.setMenuId(menuId);
	                    newItem.setItemname(menu.getItemname());
	                    newItem.setPrice(menu.getPrice());
	                    newItem.setQuantity(1);
	                    newItem.setRestaurantId(restaurantId);
	                    newItem.setRestaurantName(restaurant.getName());

	                    cartImp.addToCart(newItem);
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        resp.sendRedirect("cart");
	    }
}
