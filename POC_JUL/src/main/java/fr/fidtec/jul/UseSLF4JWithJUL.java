package fr.fidtec.jul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseSLF4JWithJUL {

	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(UseSLF4JWithJUL.class);
		 		
		logger.info("Hello World !!!! en mode info");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Hello World !!!! en mode debug");
		}
		logger.error("This is an error message");
	}

}
