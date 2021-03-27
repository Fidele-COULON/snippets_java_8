package fr.fidtec.applets;
import java.applet.Applet;
import java.awt.Graphics;

public class Bonjour extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String BONJOUR_MESSAGE_1 = "Bonjour de java !";
	
	private static final String NOM_PARAM = "nom";
	
	private static final String BONJOUR_MESSAGE_2 = "Java te dit bonjour !";
	 
	private String msg = "NEW";
			
	// Est appele une seule fois au demarrage de l'applet et qui permet d'effectuer des initialisations
	public void init() {
		msg = BONJOUR_MESSAGE_1;
		
		// recuperation du parametre nom
		String parm=getParameter(NOM_PARAM);
		 
		// s'il existe, on change le message par defaut
		if (parm != null) { 
			 msg = parm + BONJOUR_MESSAGE_2;
		}
	}
 
	// Est appele a chaque fois qu'il est necessaire d'afficher l'applet 
	public void paint(Graphics g) {
		g.drawString(msg, 20, 20);
	}
	 
}
