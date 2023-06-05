package fr.fidtec.jul;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class RunMeAgain {

	private static final Logger LOGGER = Logger.getLogger(RunMeAgain.class.toString());
	
	// Le bloc statique pour configurer le gestionnaire de logs
	
	// Récupération de notre gestionnaire de logs.
    private static final LogManager logManager = LogManager.getLogManager();
    
	public static void main(String[] args) {
		System.out.println("Bienvenue avec JUL !");

		LOGGER.setLevel(Level.ALL);
		
		LOGGER.finest("Coucou en fine !");
		LOGGER.finer("Coucou en fine !");
		LOGGER.fine("Coucou en fine !");
		LOGGER.info("Coucou en info !");
		LOGGER.config("Coucou en config !");
		LOGGER.severe("Coucou en severe !");
		
		LOGGER.log(Level.WARNING, "Coucou en warning !");
	}

}
