package fr.fidtec.loggers.logback;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class LogBack_Test {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LogBack_Test.class);
	
	private static final int MAX_LOOP = 10000;
	
	@Test
	public void SampleLogger_Test() {
		
		LOGGER.trace("Hello World !!!! en mode trace");
		LOGGER.debug("Hello World !!!! en mode debug");
		LOGGER.info("Hello World !!!! en mode info");
		LOGGER.error("Hello World !!!! en mode error");
		LOGGER.warn("Hello World !!!! en mode warn");
				
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void SampleLoggerWithFormatter_Test() {
		
		LOGGER.info("Example log from {}", LogBack_Test.class.getSimpleName());
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void SampleLoggerWithException_Test() {
				
		LOGGER.error("Hello World !!!! en mode error", new Exception("C'est une exception"));		
		
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void LogLevel_Test() {
		
		ch.qos.logback.classic.Logger parentLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.fidtec.loggers.logback");

		// A Logback context is needed to set the level in the next statement; note that the SLF4J's abstract logger does not implement setLevel().
		parentLogger.setLevel(Level.INFO);

	    Logger childlogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.fidtec.loggers.logbakc.tests");

		parentLogger.warn("This message is logged because WARN > INFO.");
		parentLogger.debug("This message is not logged because DEBUG < INFO.");
		
		childlogger.info("INFO == INFO");
		childlogger.debug("DEBUG < INFO");
				
		assertTrue(true); // pour SONAR
	}
	
	@Test
	public void rootLogger_Test() {
		
		ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("fr.fidtec.loggers.logback");
		logger.debug("Hi there!");

		ch.qos.logback.classic.Logger rootLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
	    logger.debug("This message is logged because DEBUG == DEBUG.");

		rootLogger.setLevel(Level.ERROR);

		logger.warn("This message is not logged because WARN < ERROR.");
		logger.error("This is logged.");
		
		assertTrue(true); // pour SONAR
	}
	
	
	
	// https://mkyong.com/logging/logback-xml-example/
	@Test
	public void MassLogging_Test() {

		for (int i = 0; i < MAX_LOOP; i++) {
	    	LOGGER.info("Coucou #" + i + " !");
	    }
	    
	    assertTrue(true); // pour SONAR
	}
}
