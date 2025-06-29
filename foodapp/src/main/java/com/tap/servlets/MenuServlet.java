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
import DaoInterface.MenuDao;
import domain.Cartitem;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("menu");
	int r = Integer.parseInt(req.getParameter("restaurantId"));

	MenuImp1 m = new MenuImp1();
	List<domain.Menu> allMenu = m.getAllMenu(r); // ✅ This method exists

	req.setAttribute("allMenu", allMenu);
	req.setAttribute("restaurantId", r);

	RequestDispatcher d = req.getRequestDispatcher("menu.jsp");
	d.forward(req, resp);

}


//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    // Retrieve item details from the request parameters
//    int itemId = Integer.parseInt(request.getParameter("itemId"));
//    String itemName = request.getParameter("itemName");
//    int price = Integer.parseInt(request.getParameter("price"));
//    int quantity = Integer.parseInt(request.getParameter("quantity"));
//    
//    // Create a new CartItem object with the retrieved details
//    Cartitem cartItem = new Cartitem(itemId, itemName, price, quantity);
//    
//    // Get the HttpSession object
//    HttpSession session = request.getSession(true);
//    
//    // Retrieve the list of cart items from the session, or create a new list if it doesn't exist
//    List<Cartitem> cartItems = (List<Cartitem>) session.getAttribute("cartItems");
//    if (cartItems == null) {
//        cartItems = new ArrayList<>();
//    }
//    
//    // Add the new cart item to the list
//    cartItems.add(cartItem);
//    
//    // Store the updated list of cart items back into the session
//    session.setAttribute("cartItems", cartItems);
//    
//    // Redirect back to the menu page
//    response.sendRedirect("menu");
//}


}
//@WebServlet("/menu")
//public class Menu extends HttpServlet {
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 5844138503252432103L;
//
//	@Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("menu");
//        MenuImp1 m = new MenuImp1();
//        String restaurantIdParam = req.getParameter("restaurantId");
//        if (restaurantIdParam != null) {
//            try {
//                int r = Integer.parseInt(restaurantIdParam);
//                List<domain.Menu> allMenu = m.getAllMenu(r);
//                System.out.println("menulist");
//                req.setAttribute("allMenu", allMenu);
//                RequestDispatcher d = req.getRequestDispatcher("menu.jsp");
//                d.forward(req, resp);
//            } catch (NumberFormatException e) {
//                // Handle invalid restaurantId parameter
//                e.printStackTrace();
//                // You might want to send an error response here
//            }
//        } else {
//            System.out.println("redirect");
//            
//        	
//        }
//    }

