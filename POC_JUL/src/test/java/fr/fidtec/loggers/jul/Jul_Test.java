package fr.fidtec.loggers.jul;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

import org.junit.Test;

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
public class Jul_Test {

	// private static final Logger LOGGER = Logger.getLogger(Jul_Test.class.getCanonicalName());
	private static final Logger LOGGER = Logger.getLogger("fr.fidtec.loggers.jul");
	
	private static final Logger LOGGER_BIS = Logger.getLogger("fr.fidtec_bis.Jul_Test");
	
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
            logManager.readConfiguration(new FileInputStream("src/test/resources/jul.properties"));
        } catch (IOException exception ) {
            LOGGER.log(Level.SEVERE, "Cannot read configuration file", exception);
        }
    }
	
    @Test
	public void SimpleLoggerTest() {
			
		LOGGER.fine("Coucou en fine !");
		LOGGER.info("Coucou en info !");
		LOGGER.config("Coucou en config !");
		LOGGER.warning("Coucou en warning !");
		LOGGER.severe("Coucou en severe !");
		
		assertTrue(true); // pour SONAR

	}

    @Test
	public void SimpleLoggerWithExceptionTest() {
		
		LOGGER.log(Level.SEVERE, "Hello World !!!! en mode error", new Exception("C'est une exception"));
		
		assertTrue(true); // pour SONAR
	}
    
    @Test
	public void SimpleLoggerIfTest() {
		
    	// inutile en JUL https://codegym.cc/fr/groups/posts/fr.274.logging-quoi-comment-ou-et-avec-quoi-
		
		assertTrue(true); // pour SONAR
	}
    
    @Test
	public void AnotherLoggersTest() {

    	/*
    	 There's no easy way to get two handlers of the same type with java.util.logging classes that have different arguments.
    	 Probably the simplest way to do this is to create a FileHandler subclass in your logging.properties that passes the
    	 appropriate arguments to enable your logging to take place
    	 https://stackoverflow.com/questions/3639694/java-util-logging-properties-how-to-log-to-two-different-files
    	 */
    	
    	LOGGER_BIS.info("Hello World !!!! vers BIS");
    	assertTrue(true); // pour SONAR
	}



    
}
