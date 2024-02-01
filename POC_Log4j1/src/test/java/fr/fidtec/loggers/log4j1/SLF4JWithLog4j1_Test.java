package fr.fidtec.loggers.log4j1;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.MDC;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JWithLog4j1_Test {

	@Test
	public void SL4J_Test() {
		
		Logger logger = LoggerFactory.getLogger(SLF4JWithLog4j1_Test.class);
		 
		logger.info("Hello World !!!! en mode info sans MDC");
		
		MDC.put("UserName","Fidele COULON");
		
		logger.info("Hello World !!!! en mode info avec MDC");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Hello World !!!! en mode debug avec MDC");
		}
		
		logger.error("This is an error message avec MDC", new Exception("Ceci est une exception"));
		
		assertTrue(true); // pour SONAR
		
	}
}
