package fr.fidtec.tools;

import java.util.Date;

public class CSRF_Utils {

	private CSRF_Utils() {} // pour empêcher l'instanciation
	
	public static final String CSRF_TOKEN = "CSRFToken";
	
	public static String generateCSRFToken() {
		return CSRF_TOKEN + "_" + new Date().toString();
	}
}
