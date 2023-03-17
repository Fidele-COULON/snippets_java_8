package fr.fidtec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/POC_JAAS_TOMCAT_JSP/HelloWorld
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("Hello World !!! on " + request.getContextPath());
		String userName = request.getUserPrincipal().getName();
		response.getWriter().println("User :" + userName);
		response.getWriter().println("Role Users :" + request.isUserInRole("users"));
		response.getWriter().println("Role Admins :" + request.isUserInRole("admins"));
		response.getWriter().println("Is HTTPS :" + request.isSecure());
		response.getWriter().println("AuthType :" + request.getAuthType());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
