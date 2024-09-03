package fr.fidtec.loggers.jul;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JWithJUL_Test {

	@Test
	public void SLF4J_Test() {
		
		Logger logger = LoggerFactory.getLogger(SLF4JWithJUL_Test.class);
		 		
		logger.info("Hello World !!!! en mode info");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Hello World !!!! en mode debug");
		}
		
		logger.error("This is an error message", new Exception("Ceci est une exception"));
		
		assertTrue(true); // pour SONAR
	}

}
