package fr.fidtec.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSession session= request.getSession();
        // session.invalidate();
		request.logout();
		response.getWriter().println("Deconnecte !!!");
		
		
        // RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
        // rd.forward(request, response);
        
        response.sendRedirect(response.encodeRedirectURL("Login.jsp"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
