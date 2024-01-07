package fr.fidtec.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// http://localhost:8080/POC_JAAS_TOMCAT_JSP/Logout
// http://localhost:8080/POC_JAAS_TOMCAT_JSP/Logout?invalidate=1
// http://localhost:8080/POC_JAAS_TOMCAT_JSP/Logout?forward=1
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	/*
	 * Le mécanisme d'authentification BASIC n'est pas fait pour la déconnexion.
	 * Envoyer une erreur 401 ne marche pas tout le temps. Le meilleur moyen est de
	 * fermer le navigateur.
	 * 
	 * Maintenant pour gérer une déconnexion, c'est beaucoup plus facile, il suffit
	 * d'invalider la session ou d'utiliser logout()
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (request.getParameter("invalidate") != null) {
    		System.out.println("Session invalidate !"); //NOSONAR
    		HttpSession session= request.getSession();
            session.invalidate();
    	} else {
    		System.out.println("Session logout !"); //NOSONAR
    		request.logout();
    	}
		
    	response.getWriter().println("Deconnecte !!!");
		
    	if (request.getParameter("forward") != null) {
    		System.out.println("Session forward !"); //NOSONAR
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
    	} else {
    		System.out.println("Session redirect !"); //NOSONAR
    		response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
    	}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
