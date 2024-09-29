package fr.fidtec.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Perf {

	private static final Logger LOGGER = LogManager.getLogger(Log4j2Perf.class);
	
	private static final int COUNTER = 1_000_000_000; 
	
	// COUNTER 1000000000 de logs désactivés
	// 2119 contre 2072 en console avec "HelloWord !!!"
	// 75278/1671/4798 en console avec "HelloWord !!!" + i
	
	public static void main(String[] args) {
		
		long debut = System.currentTimeMillis();
		
		for (int i=0; i < COUNTER; i ++) {
			LOGGER.info("HelloWord !!!" + i);
		}
		
		System.out.println("Durée 1 : " + (System.currentTimeMillis() - debut));
		
		debut = System.currentTimeMillis();
		
		for (int i=0; i < COUNTER; i ++) {
			
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("HelloWord !!!" + i);
			}
			
		}
		
		System.out.println("Durée 2 : " + (System.currentTimeMillis() - debut));
		
		
		debut = System.currentTimeMillis();
		
		for (int i=0; i < COUNTER; i ++) {
				LOGGER.info("HelloWord !!! {}", i);
		}
		
		System.out.println("Durée 3 : " + (System.currentTimeMillis() - debut));
		
	}
}
