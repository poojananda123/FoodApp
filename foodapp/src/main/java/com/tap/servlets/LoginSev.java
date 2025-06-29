package com.tap.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImplementation.UserImp;
import domain.Users;

public class LoginSev extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");

        if (uname == null || pass == null) {
            req.setAttribute("error", "Username or password missing");
            req.getRequestDispatcher("login1.jsp").forward(req, resp);
            return;
        }

        String encryptedUsername = encryptString(uname);
        String encryptedPassword = encryptString(pass);

        UserImp dao = new UserImp();
        Users user = dao.getUsers(encryptedUsername, encryptedPassword);

        if (user != null) {
            HttpSession session = req.getSession(); // Create session
            session.setAttribute("user", user);
            session.setAttribute("userId", user.getUserId());

            System.out.println("userId saved: " + user.getUserId());
            System.out.println("SessionID at login: " + session.getId());

            resp.sendRedirect(req.getContextPath() + "/home"); // ✅ Use redirect to avoid double post
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("login1.jsp").forward(req, resp);
        }
    }

    private String encryptString(String str) {
        StringBuilder encryptedStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            encryptedStr.append((char) (c + 1));
        }
        return encryptedStr.toString();
    }
}
