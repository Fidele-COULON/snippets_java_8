package fr.fidtec.Log4j2;

import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class ReadLog4JConfig {

	final static Logger logger = LogManager.getLogger(ReadLog4JConfig.class);
	
	private final static String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/log4j2.xml";
	
	private final static String MY_LOGGER_NAME = "fr.fidtec.Log4j2.ReadLog4JConfig";
	
	final static String CONSOLE = "Console2";
	
	final static String FILE_LOG = "FILE_LOG";
	
	public static void main(String[] args) {
		   LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
		    File file = new File(NOM_FICHIER_CONFIG_LOG4J2);     
	        context.setConfigLocation(file.toURI());
	        
	        ThreadContext.put("UserName", "Fidele COULON");
	        
			logger.trace("Hello World !!!! en mode trace - loginId=User1");		
			logger.trace("Hello World !!!! en mode trace - loginId=User2");
			
			logger.debug("Hello World !!!! en mode debug - loginId=User1");		
			logger.debug("Hello World !!!! en mode debug - loginId=User2");
			
			final Configuration config = context.getConfiguration();

			// Liste les loggers configurés
			Map<String, LoggerConfig> loggersMap = config.getLoggers();
			for (String alogger:loggersMap.keySet()) {
				System.out.println("Logger :" + alogger);
			}
			
			//	config.getRootLogger().removeAppender(CONSOLE);			
			config.getLoggerConfig(MY_LOGGER_NAME).removeAppender(FILE_LOG);
			context.updateLoggers();
			
			logger.debug("Hello World !!!! en mode debug - loginId=User1");		
			logger.debug("Hello World !!!! en mode debug - loginId=User2");
			
	}

}
