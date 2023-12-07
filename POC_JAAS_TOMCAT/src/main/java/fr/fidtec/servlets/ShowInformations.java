package fr.fidtec.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// http://localhost:8080/POC_JAAS_TOMCAT/ShowInformations
public class ShowInformations extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    
	    try {
	    	
		    PrintWriter out = response.getWriter();

		    // start html
		    out.println("<!DOCTYPE html>");
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>ShowInformations</title>");
		    out.println("</head>");
		    out.println("<body>");
		    
		    // Query params
		    out.println("<h1>Query params</h1>");
		    out.println("getQueryString = " + request.getQueryString());

		    // Cookies
		    out.println("<h1>Cookies</h1>");
		        	
		    Cookie[] cookies = request.getCookies();
		    
		    if (cookies != null ) {
			    for (int i = 0; i < cookies.length; i++) {
			      String name = cookies[i].getName();
			      String value = cookies[i].getValue();
			      out.println(name + " = " + value + "<br>");
			    }		    
		    } else {    
			    out.println("<p>Pas de cookies !!! </p>");
		    }
		    
		    // Headers
		    out.println("<h1>Headers</h1>");
		    Enumeration<String> headerNames = request.getHeaderNames();
		    while(headerNames.hasMoreElements()) {
		    	String headerName = headerNames.nextElement();
		    	out.println(headerName + " = " + request.getHeader(headerName) + "<br>");
		     }
		    
		    // end html
		    out.println("</body>");
		    out.println("</html>"); 	
		    
	    } catch (IOException ioe) {
	    	ioe.printStackTrace();
	    }
	}
}
