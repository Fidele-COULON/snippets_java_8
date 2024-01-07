package fr.fidtec.servlets;

import fr.fidtec.tools.CSRF_Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

// Cross Site Scripting (XSS)
public class HttpRequestFilterXSS extends HttpServletRequestWrapper {
	
	public HttpRequestFilterXSS(HttpServletRequest request) {
        super(request);
	}

	@Override
	public String getParameter(String name) {
		return super.getParameter(name) + (name.equals(CSRF_Utils.CSRF_TOKEN) ? "" : " filtré XSS");
	}
}
