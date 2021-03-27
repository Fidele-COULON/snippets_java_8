package fr.fidtec.parsers;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LecteurSimpleXML {

	public static void main(String[] args) {
		// Nous r�cup�rons une instance de factory qui se chargera de nous fournir un parseur
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    try {

	         // Cr�ation de notre parseur via la factory
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         
	         // parsing de notre fichier via un objet File et r�cup�ration d'un objet Document
	         // Ce dernier repr�sente la hi�rarchie d'objet cr��e pendant le parsing
             //  File fileXML = new File("test.xml");
	         File fileXML = new File("src/main/resources/test.xml");
	       
	         Document xml = builder.parse(fileXML);

	         // Syntaxe d'un Parsing d'un XML via une URL
             // String uri = "http://www.w3schools.com/xml/note.xml";
	         // Document xml = builder.parse(uri);

	         // Syntaxe d'un Parsing d'un XML via un flux
	         // InputStream is = new FileInputStream(fileXML);
	         // Document xml = builder.parse(is);

	         // Via notre objet Document, nous pouvons r�cup�rer un objet Element
	         // Ce dernier repr�sente un �l�ment XML qui sera la racine du document (via getDocumentElement)
	         Element root = xml.getDocumentElement();
	         System.out.println(root.getNodeName());
  	   
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}	
	