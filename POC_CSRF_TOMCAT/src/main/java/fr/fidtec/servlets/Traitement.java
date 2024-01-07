package fr.fidtec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import fr.fidtec.tools.CSRF_Utils;

// http://localhost:8080/POC_CSRF_TOMCAT/traitement
 
@WebServlet(name = "traitement", urlPatterns = {"/traitement"})
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Traitement() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doStuff(new HttpRequestFilterXSS(request), response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doStuff(new HttpRequestFilterXSS(request), response);
	}
    
    private void doStuff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		pw.println("<H1>Hello World !!! on " + request.getContextPath() + "</H1>");
		
		// Vérification CSRF
		HttpSession session = request.getSession(true);
		
		Object obj = session.getAttribute(CSRF_Utils.CSRF_TOKEN);
		
		String tokenfromSession = obj != null ? (String) obj : "Jeton non trouvé" ;
		pw.println("tokenfromSession = " + tokenfromSession);
		
		pw.println("<br/>");
		
		String tokenfromParameter = request.getParameter(CSRF_Utils.CSRF_TOKEN);
		pw.println("tokenfromParameter = " + tokenfromParameter);
		
		pw.println("<br/>");
		
		if (tokenfromSession.equals(tokenfromParameter)) {
			pw.println("Vérification OK");
		} else {
			pw.println("Vérification KO");
		}
		
		// Query params
		pw.println("<h1>Query params</h1>");
		pw.println("getQueryString = " + request.getQueryString());
	    
	    // Query params
		pw.println("<h1>getParameter user_name modifié par le wrapper</h1>");
		pw.println("getParameter = " + request.getParameter("username"));
		
		// Header
		pw.println("<h1>getHeader</h1>");
		pw.println("getHeader = " + request.getHeader(CSRF_Utils.CSRF_TOKEN));
						
     	pw.close();
    }

}
