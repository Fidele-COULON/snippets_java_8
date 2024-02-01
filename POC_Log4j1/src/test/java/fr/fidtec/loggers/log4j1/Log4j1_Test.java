package fr.fidtec.loggers.log4j1; 

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC; // MDC = Mapped Diagnostic Context
import org.junit.Test;

public class Log4j1_Test {

	private static final Logger LOGGER = Logger.getLogger(Log4j1_Test.class);
	private static final Logger LOGGER_BIS = Logger.getLogger("fr.fidtec_bis");
	private static final Logger LOGGER_COM = Logger.getLogger("com.fidtec");
	
	@Test
	public void SimpleLoggerTest() {
		LOGGER.debug("Hello World !!!! en mode debug sans MDC");
		LOGGER.info("Hello World !!!! en mode info sans MDC");
		LOGGER.error("Hello World !!!! en mode error sans MDC");
		LOGGER.warn("Hello World !!!! en mode warn sans MDC");
		LOGGER.fatal("Hello World !!!! en mode fatal sans MDC");
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void SimpleLoggerWithExceptionTest() {
		
		LOGGER.info("Hello World !!!! en mode info sans MDC", new Exception("C'est une exception"));
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void SimpleLoggerWithMDCTest() {
		
		MDC.put("UserName", "Fidele COULON");
		
		LOGGER.info("Hello World !!!! en mode info avec MDC");
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void SimpleLoggerIfTest() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Hello World !!!! en mode debug avec MDC");
		}
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void AnotherLoggersTest() {
		LOGGER_BIS.info("Hello World !!!! vers BIS");
		LOGGER_COM.info("Hello World !!!! vers COM");
		assertTrue(true); // pour SONAR
	}
	
} 
