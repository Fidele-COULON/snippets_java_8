package fr.fidtec.POC_Log4j1; //NOSONAR

import org.apache.log4j.Logger;
import org.apache.log4j.MDC; // MDC = Mapped Diagnostic Context

public class UseLog4j1 {

	private static final Logger LOGGER = Logger.getLogger(UseLog4j1.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Hello World !!!! en mode info sans MDC");
		
		MDC.put("UserName", "Fidele COULON");
		
		LOGGER.info("Hello World !!!! en mode info avec MDC");
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Hello World !!!! en mode debug avec MDC");
		}
		
		LOGGER.error("This is an error message avec MDC");
		
		try {
			@SuppressWarnings("unused")
			int i = 3/0; // NOSONAR
		} catch (Exception e) {
			LOGGER.error("This is an error message with Exception avec MDC", e);
		}
		
	}
} 
