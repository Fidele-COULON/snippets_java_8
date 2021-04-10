package fr.fidtec.Log4j2; //NOSONAR

import java.io.File;

import org.apache.logging.log4j.CloseableThreadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://logging.apache.org/log4j/2.x/log4j-slf4j-impl/
public class UseSLF4J_Log4j2 { //NOSONAR

	private static final Logger LOGGER = LoggerFactory.getLogger(UseSLF4J_Log4j2.class);
	
	private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/syslogAppender/log4j2.xml";
	
	public static void main(String[] args) {
		
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
		File file = new File(NOM_FICHIER_CONFIG_LOG4J2);     
	    context.setConfigLocation(file.toURI());
	        
		CloseableThreadContext.put("UserName", "Fidele COULON");

		LOGGER.info("Hello World !!!! en mode info");
			
		LOGGER.debug("Hello World !!!! en mode debug");
					
		LOGGER.error("This is an error message");
		
	}

}
