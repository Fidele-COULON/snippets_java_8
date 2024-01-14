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
     	PrintWriter pw = response.getWriter();
		pw.println("<H1> Username brut :" + request.getParameter("username")+ "</H1>"); // passe
		
    	doStuff(new HttpRequestFilterXSS(request), response);
	}
    
    private void doStuff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		// Vérification CSRF
		HttpSession session = request.getSession(true);
		
		// Header
		pw.println("<h1>GetTokenFromHeader</h1>");
		String tokenfromHeader = request.getHeader(CSRF_Utils.CSRF_TOKEN);
		pw.println("tokenfromHeader = " + tokenfromHeader);
			
		// tokenfromSession
		pw.println("<h1>GetTokenfromSession</h1>");
		Object objAttribute = session.getAttribute(CSRF_Utils.CSRF_TOKEN);
		String tokenfromSession = objAttribute != null ? (String) objAttribute : "Jeton non trouvé" ;
		pw.println("tokenfromSession = " + tokenfromSession);
		
		pw.println("<br/>");
		
		// tokenfromParameter
		pw.println("<h1>GetTokenfromParameter</h1>");
		String tokenfromParameter = request.getParameter(CSRF_Utils.CSRF_TOKEN);
		pw.println("tokenfromParameter = " + tokenfromParameter);
		pw.println("<br/>");
		
		if (tokenfromSession.equals(tokenfromParameter)) {
			pw.println("Vérification avec session OK");
		} else {
			pw.println("Vérification avec session KO");
		}
		
		pw.println("<br/>");
		
		if (tokenfromHeader.equals(tokenfromParameter)) {
			pw.println("Vérification avec header OK");
		} else {
			pw.println("Vérification avec header KO");
		}
		
		// Query params
		pw.println("<h1>Query params</h1>");
		pw.println("getQueryString = " + request.getQueryString());
	    
	    // getParameter
		pw.println("<h1>GetParameter de user_name</h1>");
		pw.println("getParameter = " + request.getParameter("username"));
						
     	pw.close();
     	
     	
    }

}
