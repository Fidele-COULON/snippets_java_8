package fr.fidtec.jul;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

/*
  
    from 
    
    https://www.vogella.com/tutorials/Logging/article.html
    https://koor.fr/Java/Tutorial/java_logging_util.wp
    
    API est proposée de base par le Java SE et ce depuis sa version 1.4
   
    SEVERE (HIGHEST LEVEL)
    WARNING
    INFO
    CONFIG
    FINE
    FINER
    FINEST (LOWEST LEVEL)
    
    java.util.logging also provides two additional levels: ALL and OFF. ALL causes the Logger to log all messages regardless of level, while OFF disables logging.

	Log levels INFO and higher will be automatically written to the console.

 */
public class RunMe {

	private static final Logger LOGGER = Logger.getLogger(RunMe.class.toString());
	
	/* 
	// Le bloc statique pour configurer notre logger par code .
    static {
        try {
            FileHandler fileHandler = new FileHandler("logs.xml");
            
            // l'API JUL met à votre disposition deux formateurs : java.util.logging.SimpleFormatter et java.util.logging.XMLFormatter. De plus, vous pouvez créer vos propres formateurs en dérivant de la classe abstraite java.util.logging.Formatter. 
            fileHandler.setFormatter(new SimpleFormatter()); // par défaut logs en XML, on bascule en texte simple

            LOGGER.addHandler(fileHandler);
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Cannot read configuration file", exception);
        }
    }
    */
	
	// Le bloc statique pour configurer le gestionnaire de logs
	
	// Récupération de notre gestionnaire de logs.
    private static final LogManager logManager = LogManager.getLogManager();
    
    static{
        try {
            logManager.readConfiguration(new FileInputStream("src/main/resources/jul.properties"));
        } catch (IOException exception ) {
            LOGGER.log(Level.SEVERE, "Cannot read configuration file", exception);
        }
    }
	
	public static void main(String[] args) {
			
		LOGGER.setLevel(Level.ALL);
		
		LOGGER.fine("Coucou en fine !");
		LOGGER.info("Coucou en info !");
		LOGGER.config("Coucou en config !");
		LOGGER.severe("Coucou en severe !");

	}

}
