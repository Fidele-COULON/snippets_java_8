package fr.fidtec.Log4j2; //NOSONAR

import java.io.File;

import org.apache.logging.log4j.CloseableThreadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;

public class UseLog4j2 {

	private static final Logger LOGGER = LogManager.getLogger(UseLog4j2.class);
	
	private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/syslogAppender/log4j2.xml";
	// private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/filteredAppender/log4j2.xml"; //NOSONAR
	// private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/customAppender/log4j2.xml"; //NOSONAR
	// private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/log4j2.xml"; //NOSONAR
	// private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/withMDC/log4j2.xml"; //NOSONAR
	
	public static void main(String[] args) {
		
		Exception e = new RuntimeException("This is only a test!");
		
	    LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
	    File file = new File(NOM_FICHIER_CONFIG_LOG4J2);     
        context.setConfigLocation(file.toURI());
		    
        ThreadContext.put("UserName", "Fidele COULON"); //NOSONAR
        
  
                
        LOGGER.trace("Hello World !!!! en mode trace - loginId=User1");		
        LOGGER.trace("Hello World !!!! en mode trace - loginId=User2");
		
        LOGGER.debug("Hello World !!!! en mode debug - loginId=User1");		
        LOGGER.debug("Hello World !!!! en mode debug - loginId=User2");
		
		LOGGER.info("Hello World !!!! en mode info - loginId=User1");
		LOGGER.info("Hello World !!!! en mode info - loginId=User2");
		
		LOGGER.warn("Hello World !!!! en mode warn - loginId=User1");
		LOGGER.warn("Hello World !!!! en mode warn - loginId=User2");
		
		LOGGER.error("Hello World !!!! en mode error - loginId=User1"); //NOSONAR
		LOGGER.error("Hello World !!!! en mode error - loginId=User2");	
	
		
        try (final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("UserName", "Laurence TOURBEZ")) {
        	LOGGER.error("Hello World !!!! en mode error - loginId=User1");
    		LOGGER.error("Hello World !!!! en mode error - loginId=User1");	
        }
		
    	LOGGER.fatal("Hello World !!!! en mode fatal - loginId=User1");
		LOGGER.fatal("Hello World !!!! en mode fatal - loginId=User1");	
		
		ThreadContext.put("UserName", "Rolo Tomassi");
		
		LOGGER.error("\"Hello World !!!! en mode error message with exception", e);
	}
} 
