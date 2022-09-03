package fr.fidtec.bridgelog4j;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC; // MDC = Mapped Diagnostic Context

// https://logging.apache.org/log4j/2.x/manual/migration.html
public class UseBridgeLog4j1 {

	private static final String LOG4J_CONFIGFILE = "file:src/main/resources/fws.properties";
	
	public static void main(String[] args) throws IOException {
		
		// -Dlog4j1.compatibility="true" -Dlog4j.configuration=file:src/main/resources/fws.properties 
		System.setProperty("log4j1.compatibility", "true");
		System.setProperty("log4j.configuration", LOG4J_CONFIGFILE);
		
		final Logger LOGGER = Logger.getLogger(UseBridgeLog4j1.class);
		
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
