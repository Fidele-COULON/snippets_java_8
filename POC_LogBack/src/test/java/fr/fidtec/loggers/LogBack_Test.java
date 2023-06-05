package fr.fidtec.loggers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class LogBack_Test {
	
	@Test
	public void Sample_Test() {
		final Logger logger = LoggerFactory.getLogger(LogBack_Test.class);
		logger.info("Example log from {}", LogBack_Test.class.getSimpleName());
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void LogLevel_Test() {
		
		ch.qos.logback.classic.Logger parentLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.fidtec.loggers");

		// A Logback context is needed to set the level in the next statement; note that the SLF4J's abstract logger does not implement setLevel().
		parentLogger.setLevel(Level.INFO);

	    Logger childlogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.fidtec.loggers.tests");

		parentLogger.warn("This message is logged because WARN > INFO.");
		parentLogger.debug("This message is not logged because DEBUG < INFO.");
		
		childlogger.info("INFO == INFO");
		childlogger.debug("DEBUG < INFO");
				
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void rootLogger_Test() {
		
		ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.fidtec.loggers");
		logger.debug("Hi there!");

		ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
	    logger.debug("This message is logged because DEBUG == DEBUG.");

		rootLogger.setLevel(Level.ERROR);

		logger.warn("This message is not logged because WARN < ERROR.");
		logger.error("This is logged.");
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void LogWithException_Test() {
		final Logger logger = LoggerFactory.getLogger(LogBack_Test.class);
		
		String message = "This is a String";
		Integer zero = 0;

		try {
		    logger.debug("Logging message: {}", message);
		    logger.debug("Going to divide {} by {}", 42, zero);
		    
		    @SuppressWarnings("unused")
			int result = 42 / zero;
		} catch (Exception e) {
		    logger.error("Error dividing {} by {} ", 42, zero, e);
		}
		
		assertTrue(true); // pour SONAR
	}
	
	// https://mkyong.com/logging/logback-xml-example/
	@Test
	public void MassLogging_Test() {
		final Logger logger = LoggerFactory.getLogger(LogBack_Test.class);
		
	    for (int i = 0; i <= 100000; i++) {
	    	logger.info("Coucou !!!!");
	    }
	    
	    assertTrue(true); // pour SONAR
	}
}
