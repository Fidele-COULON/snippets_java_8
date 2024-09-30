package fr.fidtec.log4j2;

import java.io.File;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class UseRollingFileCustom {

	private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/rollingFileCustom/log4j2.xml";
	
	private static final Logger LOGGER = LogManager.getLogger(UseRollingFileCustom.class);
	
	public static void main(String[] args) {

    	// ThreadContext.put("os", "windows");
       
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
	    File file = new File(NOM_FICHIER_CONFIG_LOG4J2);     
        context.setConfigLocation(file.toURI());

        LOGGER.trace("Hello World !!!! en mode trace - loginId=User1");		
        LOGGER.trace("Hello World !!!! en mode trace - loginId=User2");
		
        LOGGER.debug("Hello World !!!! en mode debug - loginId=User1");		
        LOGGER.debug("Hello World !!!! en mode debug - loginId=User2");
		
		LOGGER.info("Hello World !!!! en mode info - loginId=User1");
		LOGGER.info("Hello World !!!! en mode info - loginId=User2");
		
		LOGGER.warn("Hello World !!!! en mode warn - loginId=User1");
		LOGGER.warn("Hello World !!!! en mode warn - loginId=User2");
		
		LOGGER.error("Hello World !!!! en mode warn - loginId=User1");
		LOGGER.error("Hello World !!!! en mode warn - loginId=User2");

	}

}
