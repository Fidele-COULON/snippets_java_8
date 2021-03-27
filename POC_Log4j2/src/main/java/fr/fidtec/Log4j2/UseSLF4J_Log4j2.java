package fr.fidtec.Log4j2;

import org.apache.logging.log4j.CloseableThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseSLF4J_Log4j2 {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(UseSLF4J_Log4j2.class);
		
		@SuppressWarnings("unused")
		final CloseableThreadContext.Instance ctc = CloseableThreadContext.put("UserName", "Fidele COULON");
		
		System.out.println("Debut");
		 
		logger.info("Hello World !!!! en mode info");
			
		logger.debug("Hello World !!!! en mode debug");
					
		logger.error("This is an error message");
		
		System.out.println("Fin");
	}

}
