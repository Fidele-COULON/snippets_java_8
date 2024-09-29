package fr.fidtec.parsers;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LecteurSimpleXML {

	// On récupère une instance de DocumentBuilderFactory qui se chargera de nous fournir un parser
	private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
	public static void main(String[] args) {

	    try {

	         // Creation du parseur via la factory
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         
	         // 1. Parsing du fichier via un objet File 
	         // On recupere un objet Document qui represente la hierarchie d'objet cree
	         File fileXML = new File("src/main/resources/test.xml");	       
	         Document xml = builder.parse(fileXML);

	         // 2. Syntaxe d'un Parsing d'un XML via une URL
             // String uri = "http://www.w3schools.com/xml/note.xml";
	         // Document xml = builder.parse(uri);

	         // 3. Syntaxe d'un Parsing d'un XML via un flux
	         // InputStream is = new FileInputStream(fileXML);
	         // Document xml = builder.parse(is);

	         // Via l'objet Document, nous pouvons r�cup�rer un objet Element
	         // Ce dernier represente un element XML qui sera la racine du document (via getDocumentElement)
	         Element root = xml.getDocumentElement();
	         System.out.println("RootNodeName = " + root.getNodeName());
	         
	         NodeList nodes = root.getChildNodes();
	         
	         System.out.println("nb noeuds : " + nodes.getLength());
	         for(int i=0; i < nodes.getLength(); i++) {
	        	 System.out.println(i + "-" + nodes.item(i).getNodeName() + "=" + nodes.item(i).getTextContent());	 
	         }
	         
	       
  	   
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
}	
	