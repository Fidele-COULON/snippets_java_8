package fr.fidtec.filters;

import fr.fidtec.tools.CSRF_Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class DetectXSSWrapper extends HttpServletRequestWrapper {

	public DetectXSSWrapper(HttpServletRequest request) {
        super(request);
    }
	
	@Override
	public String getParameter(String name) {
		return super.getParameter(name)+ (name.equals(CSRF_Utils.CSRF_TOKEN) ? "" : "_detect XSS");
    }
	
}
