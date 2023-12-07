package fr.fidtec.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// http://localhost:8080/POC_JAAS_TOMCAT/HelloWorld
// http://localhost:8080/POC_JAAS_TOMCAT/HelloWorld?redirect=1
// http://localhost:8080/POC_JAAS_TOMCAT/HelloWorld?forward=1

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloWorld() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println("<H1>Hello World !!! on " + request.getContextPath() + "</H1>");
		
		String remoteUser = request.getRemoteUser();
		pw.println("<br/>Remote User : " + remoteUser);
		
		String userName = request.getUserPrincipal().getName();
		pw.println("<br/>UserPrincipalName : " + userName);
		
		pw.println("<br/>Role Users : " + request.isUserInRole("users"));
		pw.println("<br/>Role Admins : " + request.isUserInRole("admins"));
		
		pw.println("<br/>Is HTTPS : " + request.isSecure()); // false
		pw.println("<br/>AuthType : " + request.getAuthType()); // BASIC ou DIGEST
		
		// Header
		response.addHeader("NameInHeader", "Fidele_COULON");
		
		// Cookie
	    Cookie cookie = new Cookie("NameInCookies", "Fidele_COULON");
	    response.addCookie(cookie);	

		if (request.getParameter("redirect") != null) {			
			System.out.println("Redirect détecté !"); // NOSONAR
			response.sendRedirect(request.getContextPath() + "/ShowInformations");
			
			// URL perdue : http://localhost:8080/POC_JAAS_TOMCAT/ShowInformations
			// getQueryString perdu
			// cookie NameInCookies conservé
			// header NameInHeader conservé	
					
		} else if (request.getParameter("forward") != null) {
			System.out.println("Forward détecté !"); // NOSONAR
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowInformations");
		    dispatcher.forward(request, response);	   
		    
		    // URL conservée : http://localhost:8080/POC_JAAS_TOMCAT/HelloWorld?forward=1
			// getQueryString conservé
			// cookie NameInCookies perdu
			// header NameInHeader perdu
		}
		
		pw.close();
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
