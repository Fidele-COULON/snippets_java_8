package fr.fidtec.log4j1;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseSLF4JWithLog4j1 {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(UseSLF4JWithLog4j1.class);
		 
		logger.info("Hello World !!!! en mode info sans MDC");
		
		MDC.put("UserName","Fidele COULON");
		
		logger.info("Hello World !!!! en mode info avec MDC");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Hello World !!!! en mode debug avec MDC");
		}
		logger.error("This is an error message avec MDC");
	}

}
