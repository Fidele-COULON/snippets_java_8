package fr.fidtec.filters;

import java.io.IOException;

import fr.fidtec.tools.CSRF_Utils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// https://stackoverflow.com/questions/2811769/adding-an-http-header-to-the-request-in-a-servlet-filter
public class CSRFFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {	
		
		HttpSession session = ((HttpServletRequest) request).getSession(true);// don't create if it doesn't exist

		System.out.println("Passage par CSRFFilter :" + session.getAttribute(CSRF_Utils.CSRF_TOKEN) + " - " + request.getParameter(CSRF_Utils.CSRF_TOKEN));
		
		if (session == null || session.isNew() ||
		   request.getParameter(CSRF_Utils.CSRF_TOKEN) == null || session.getAttribute(CSRF_Utils.CSRF_TOKEN) == null ||
		   ! request.getParameter(CSRF_Utils.CSRF_TOKEN).equals(session.getAttribute(CSRF_Utils.CSRF_TOKEN)) ) {		   
		    ((HttpServletResponse) response).sendRedirect("redirect.html");
		}
		
		chain.doFilter(new AddCSRFHeaderWrapper((HttpServletRequest) request), response);
	}

}
