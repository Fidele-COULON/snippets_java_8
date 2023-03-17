package fr.fidtec.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8080/POC_JAAS_TOMCAT_JSP/Forward

@SuppressWarnings("serial")
public class Forward extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Header
	    response.addHeader("User", "Fidele_COULON");
	    
	    // Cookie
	    Cookie cookie = new Cookie("Name", "Fidele_COULON");
	    response.addCookie(cookie);	
	    
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowInformations");
	    dispatcher.forward(request, response);
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
