package fr.fidtec.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8080/POC_JAAS_TOMCAT_JSP/SendRedirect
	
@SuppressWarnings("serial")
public class SendRedirect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Header
	    response.addHeader("User", "Fidele_COULON");
	    
	    // Cookie
	    Cookie cookie = new Cookie("Name", "Fidele_COULON");
	    response.addCookie(cookie);	
		
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		response.sendRedirect(request.getContextPath() + "/ShowInformations");
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
