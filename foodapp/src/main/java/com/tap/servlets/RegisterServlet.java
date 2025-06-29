package com.tap.servlets;

import DaoImplementation.UserImp;
import domain.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
 // this should match your form action
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        long phone = Long.parseLong(req.getParameter("phone"));

        String encryptedUsername = encryptString(username);
        String encryptedPassword = encryptString(password);

        Users user = new Users();
        user.setName(name);
        user.setUsername(encryptedUsername);
        user.setEmail(email);
        user.setAddress(address);
        user.setPassword(encryptedPassword);
        user.setPhone(String.valueOf(phone));
        user.setRole("user");

        UserImp dao = new UserImp();
        dao.saveUser(user);

        // Redirect to login page
        resp.sendRedirect("login1.jsp");
    }

    private String encryptString(String str) {
        StringBuilder encryptedStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            encryptedStr.append((char) (c + 1));
        }
        return encryptedStr.toString();
    }
}
