package fr.fidtec.Log4j2;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.message.MessageFactory;

public class MyLogger extends Logger {

	protected MyLogger(LoggerContext context, String name, MessageFactory messageFactory) {
		super(context, name, messageFactory);
		// TODO Auto-generated constructor stub
	}

}
