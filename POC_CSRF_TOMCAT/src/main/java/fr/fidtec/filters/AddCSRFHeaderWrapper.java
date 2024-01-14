package fr.fidtec.filters;

import fr.fidtec.tools.CSRF_Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AddCSRFHeaderWrapper extends HttpServletRequestWrapper {

	public AddCSRFHeaderWrapper(HttpServletRequest request) {
        super(request);
    }
	
	@Override
	public String getHeader(String name) {
		if (CSRF_Utils.CSRF_TOKEN.equals(name)) {
			return  CSRF_Utils.generateCSRFToken();
		} else {
			return super.getHeader(name);
		}
    }
	
}
