package fr.fidtec.parsers;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParcoursXML {

	public static void main(String[] args) {
		// Nous r�cup�rons une instance de factory qui se chargera de nous fournir un parseur
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    try {

	         // Cr�ation de notre parseur via la factory
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         
	         // parsing de notre fichier via un objet File et r�cup�ration d'un objet Document
	         // Ce dernier repr�sente la hi�rarchie d'objet cr��e pendant le parsing
	         File fileXML = new File("src/main/resources/test.xml");
	         Document xml = builder.parse(fileXML);
        
	         // Via notre objet Document, nous pouvons r�cup�rer un objet Element
	         // Ce dernier repr�sente un �l�ment XML qui sera la racine du document (via getDocumentElement)
	         Element root = xml.getDocumentElement();
	   	         
	         System.out.println(description(root));   
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	/**
	 	* M�thode qui va parser le contenu d'un n�ud
	    * @param n
	    * @param tab
	    * @return
	    */

	   public static String description(Node n){

	      String str = new String();

	      // Nous nous assurons que le noeud pass� en param�tre est une instance d'Element
	      // juste au cas o� il s'agisse d'un texte ou d'un espace, etc.
	      if(n instanceof Element){                 

	         // Nous pouvons r�cup�rer le nom du noeud actuellement parcouru 
	         str += "<" + n.getNodeName();
        
	         // Nous contr�lons la liste des attributs pr�sents
	         if(n.getAttributes() != null && n.getAttributes().getLength() > 0){
	            // Nous pouvons r�cup�rer la liste des attributs d'un �l�ment

	            NamedNodeMap att = n.getAttributes();
	            int nbAtt = att.getLength();

	            // Nous parcourons alors tous les noeuds (attributs) pour les afficher
	            for(int j = 0; j < nbAtt; j++){
	               Node n2 = att.item(j);
	               // On r�cup�re le nom de l'attribut et sa valeur gr�ce � ces deux m�thodes
	               str += " " + n2.getNodeName() + "=\"" + n2.getNodeValue() + "\"";
	            }
	         }

	         // Nous refermons alors notre balise car nous avons trait� les diff�rents attributs
	         str += ">";

	         // La m�thode getChildNodes retournant le contenu du noeud + les noeuds enfants
	         // Nous r�cup�rons le contenu texte uniquement lorsqu'il n'y a que du texte, donc un seul enfant
	         if(n.getChildNodes().getLength() == 1)
	              str += n.getTextContent();

	         // Nous allons maintenant traiter les noeuds enfants du noeud en cours de traitement
	         int nbChild = n.getChildNodes().getLength();

	         // Nous r�cup�rons la liste des noeuds enfants
	         NodeList list = n.getChildNodes();
	         
	         // Nous parcourons la liste des n�uds
	         for(int i = 0; i < nbChild; i++){
	            Node n2 = list.item(i);

	            // si le Noeud enfant est un Element, nous le traitons
	            if (n2 instanceof Element){
	               str += "\n " + description(n2); // appel r�cursif � la m�thode pour le traitement du noeud et de ses enfants
	            }

	         }

	         // Nous fermons maintenant la balise
	         if(n.getChildNodes().getLength() < 2)
	            str += "</" + n.getNodeName() + ">";
	         else
	            str += "\n" + "</" + n.getNodeName() + ">";
	      }

	      return str;

	   }   	  
}

