package com.tap.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encript extends HttpServlet {
public Encript(String uname, String pass) {

	
	}

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String parameter = req.getParameter("uname");
	String parameter2 = req.getParameter("pass");
	
	String encryptedUsername = encryptString("parameter");
    String encryptedPassword = encryptString("parameter2");
    req.setAttribute("encryptedUsername", encryptedPassword);
    req.setAttribute("encryptedPassword", encryptedPassword);
    RequestDispatcher d= req.getRequestDispatcher("LoginSev");
    d.forward(req, resp);

}
private String encryptString(String str) {
    StringBuilder encryptedStr = new StringBuilder();
    for (char c : str.toCharArray()) {
        // Add 1 to the Unicode value of each character
        char encryptedChar = (char) (c + 1);
        encryptedStr.append(encryptedChar);
    }
    return encryptedStr.toString();
}
}
