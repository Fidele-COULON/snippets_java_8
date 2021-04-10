package fr.fidtec.Log4j2; //NOSONAR

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class ReadLog4JConfig {

	private static final Logger LOGGER = LogManager.getLogger(ReadLog4JConfig.class);
	
	private static final String NOM_FICHIER_CONFIG_LOG4J2 = "src/main/resources/log4j2.xml";
	
	private static final String MY_LOGGER_NAME = "fr.fidtec.Log4j2.ReadLog4JConfig";
	
	@SuppressWarnings("unused")
	private static final String CONSOLE = "Console2";
	
	private static final String FILE_LOG = "FILE_LOG";
	
	public static void main(String[] args) {
		
	    LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
	    File file = new File(NOM_FICHIER_CONFIG_LOG4J2);     
        context.setConfigLocation(file.toURI());
        
        ThreadContext.put("UserName", "Fidele COULON");
        
        LOGGER.trace("Hello World !!!! en mode trace - loginId=User1");		
        LOGGER.trace("Hello World !!!! en mode trace - loginId=User2");
		
        LOGGER.debug("Hello World !!!! en mode debug - loginId=User1");		
        LOGGER.debug("Hello World !!!! en mode debug - loginId=User2");
		
		final Configuration config = context.getConfiguration();

		// Liste les loggers configurés
		Map<String, LoggerConfig> loggersMap = config.getLoggers();
		for (String alogger:loggersMap.keySet()) {
			System.out.println("Logger :" + alogger); //NOSONAR
		}
		
		//	config.getRootLogger().removeAppender(CONSOLE); //NOSONAR			
		config.getLoggerConfig(MY_LOGGER_NAME).removeAppender(FILE_LOG);
		context.updateLoggers();
		
		LOGGER.debug("Hello World !!!! en mode debug - loginId=User1");		
		LOGGER.debug("Hello World !!!! en mode debug - loginId=User2");
			
	}

}
