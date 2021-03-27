package fr.fidtec.mail;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class RunMe {

	// private final static String SMTP_HOST = "smtp-mail.outlook.com";
	// private final static String SMTP_PORT = "587";

	private final static String SMTP_HOST = "127.0.0.1";
	private final static String SMTP_PORT = "25";
	
	private final static String MAIL_FROM = "fidele.coulon@hotmail.fr";
	
	private final static String PWD = "hotmail2020.";
	
	private final static String MAIL_TO = "albinrobert@ymail.com";
		
	public static void main(String[] args) {
		//sendMessageSimple("Test Mail", "Coucou", MAIL_TO, null);
		sendMessageMimeMultiPart("Test Mail", "Coucou", MAIL_TO, null);
		
	}

	public static void sendMessageSimple(String subject, String text, String destinataire, String copyDest) {

	    try { 
	    	
	    	Session session = getAMailSession();

	    	MimeMessage message = new MimeMessage(session);
	       
	        message.setSubject(subject + " (Simple Mail)");
	        message.addRecipients(Message.RecipientType.TO, destinataire);
	        if (copyDest != null) {
		    	   message.addRecipients(Message.RecipientType.CC, copyDest);
		    }
	        	       
	        message.setText(text); // si pas multiPart (équivalent mailto RFC 822, cf https://docs.microsoft.com/en-us/previous-versions/office/developer/exchange-server-2010/aa493918(v=exchg.140)
	    
	        send(session, destinataire, copyDest, message);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
	
	public static void sendMessageMimeMultiPart(String subject, String text, String destinataire, String copyDest) {
		
		try {
			
			Session session = getAMailSession();
	    
			MimeMessage message = new MimeMessage(session);
	    	       
	        message.setSubject(subject + " (MimeMultiPart)");
	        message.addRecipients(Message.RecipientType.TO, destinataire);
	        if (copyDest != null) {
	    	   message.addRecipients(Message.RecipientType.CC, copyDest);
	        }
	        
	        File file = new File("c:/temp/autruche.jpg");
	        FileDataSource fds = new FileDataSource(file);
	        DataHandler dh = new DataHandler(fds);
	        
	        MimeBodyPart autruche = new MimeBodyPart();
            autruche.setDataHandler(dh);
            autruche.setFileName(dh.getName());
	        
	        MimeBodyPart content = new MimeBodyPart();
	        content.setContent(text, "text/plain");
	        
	        MimeMultipart mimeMultipart = new MimeMultipart(); // RFC2046 + suivantes (https://fr.wikipedia.org/wiki/Multipurpose_Internet_Mail_Extensions)
	        	mimeMultipart.addBodyPart(content);
	            // mimeMultipart.addBodyPart(autruche);
	        
	        message.setContent(mimeMultipart);
	        
	        send(session, destinataire, copyDest, message);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}

	// Création de la session
	private static Session getAMailSession() {
	    Properties properties = new Properties();
	    properties.setProperty("mail.transport.protocol", "smtp");
	    properties.setProperty("mail.smtp.host", SMTP_HOST);
	    properties.setProperty("mail.smtp.port", SMTP_PORT);
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    properties.setProperty("mail.smtp.auth", "true");
	    // properties.setProperty("mail.smtp.user", MAIL_FROM); // inutile
	    properties.setProperty("mail.from", MAIL_FROM);  // obligatoire
	    Session session = Session.getInstance(properties);
	    
	    // Session session = Session.getDefaultInstance(props, null);
	    
	    return session;
	}
	
	// Envoi du message
	private static void send(Session session, String destinataire, String copyDest, Message message) {

		try (Transport transport = session.getTransport("smtp")){
	       
			transport.connect(MAIL_FROM, PWD);
	        
	        if (copyDest != null) {
	        	transport.sendMessage(message, new Address[] { new InternetAddress(destinataire), new InternetAddress(copyDest) });
	        } else {
	        	transport.sendMessage(message, new Address[] { new InternetAddress(destinataire)});
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
