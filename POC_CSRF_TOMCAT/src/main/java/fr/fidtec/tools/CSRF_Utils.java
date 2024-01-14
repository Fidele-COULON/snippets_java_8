package fr.fidtec.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CSRF_Utils {

	private CSRF_Utils() {} // pour empêcher l'instanciation
	
	public static final String CSRF_TOKEN = "CSRFToken";
	
	public static String generateCSRFToken() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy hh:mm");
		return CSRF_TOKEN + "_" + sdf.format(new Date());
	}
}
