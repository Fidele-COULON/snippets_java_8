package fr.fidtec.log4j2;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.status.StatusLogger;

public class UseStatusLogger {

	private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/main/resources/log4j2.xml";
	
	public static void main(String[] args) {
		
		LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
	    File file = new File(NOM_FICHIER_CONFIG_LOG4J2);     
        context.setConfigLocation(file.toURI());
		
	    // StatusLogger log4j 2.x = LogLog 1.x
        // le niveau est défini dans <Configuration status="INFO">
        StatusLogger.getLogger().info("StatusLogger Info");
        StatusLogger.getLogger().warn("StatusLogger Warn");
        StatusLogger.getLogger().error("StatusLogger Error");

	}

}
