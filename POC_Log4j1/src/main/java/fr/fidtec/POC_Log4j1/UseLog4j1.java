package fr.fidtec.POC_Log4j1;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC; // MDC = Mapped Diagnostic Context

public class UseLog4j1 {

	final static Logger logger = Logger.getLogger(UseLog4j1.class);
	
	public static void main(String[] args) {
		

		logger.info("Hello World !!!! en mode info sans MDC");
		
		MDC.put("UserName","Fidele COULON");
		
		logger.info("Hello World !!!! en mode info avec MDC");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Hello World !!!! en mode debug avec MDC");
		}
		logger.error("This is an error message avec MDC");
	}
} 
