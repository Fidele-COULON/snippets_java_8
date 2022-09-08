package fr.fidtec.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunMe {
	
	private static Logger logger = LoggerFactory.getLogger(RunMe.class);
	
	public static void main(String[] args) {	 
	  logger.debug("Debug log message");
	  logger.info("Info log message");
	  logger.error("Error log message");
	}

}
