package fr.fidtec.parsers;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class ValidationXMLXSD {

	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	
	public static void main(String[] args) {

	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	      	
	      try {
	    	  // Cette lignes sert � informer que la validation se fait via un fichier XSD
	          //  SchemaFactory sfactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	          // On cr�� notre sch�ma XSD
	          // Schema schema = sfactory.newSchema(new File("TestXSD.XSD"));

	          // On l'affecte � notre factory afin que le document prenne en compte le fichier XSD
	         // factory.setSchema(schema);    
	    	 
	    	 factory.setValidating(true);
	    	 factory.setNamespaceAware(true);
	    	 
	    	 factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
	    	 // factory.setAttribute(JAXP_SCHEMA_SOURCE, new File("TestXSD.xsd"));
	    	 
	         DocumentBuilder builder = factory.newDocumentBuilder();
         
	         
	         //cr�ation de notre objet d'erreurs
	         ErrorHandler errHandler = new SimpleErrorHandler();

	         //Affectation de notre objet au document pour interception des erreurs �ventuelles
	         builder.setErrorHandler(errHandler);
	         File fileXML = new File("src/main/resources/testXSD.xml");

	         //On rajoute un bloc de capture pour intercepter les erreurs au cas o� il y en ait

	         try {
	            Document xml = builder.parse(fileXML);
	            Element root = xml.getDocumentElement();
	            System.out.println(root.getNodeName() + " est valide !");
	         } catch (SAXParseException e) {
	        	 System.out.println("Erreur");
	         } // NothingToDo 

	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }  
	   }
}

