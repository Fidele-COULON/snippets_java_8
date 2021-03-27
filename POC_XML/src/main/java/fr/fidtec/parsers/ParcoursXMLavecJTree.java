package fr.fidtec.parsers;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ParcoursXMLavecJTree {

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
	         
	         // Code SWING
	         DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode(root.getNodeName());
             createJTree(root, rootTreeNode);

	         JFrame fenetre = new JFrame();
             fenetre.setLocationRelativeTo(null);
             fenetre.setSize(300, 400);
             fenetre.add(new JScrollPane(new JTree(rootTreeNode)));
             fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             fenetre.setVisible(true);
	   
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	   
	   /**
	    * M�thode qui va parser le contenu d'un noeud
	    * @param n
	    * @param tab
	    * @return
	    */
	   public static void createJTree(Node n, DefaultMutableTreeNode treeNode){

		   if(n instanceof Element){

	         if(n.getAttributes() != null && n.getAttributes().getLength() > 0){
	   
	            NamedNodeMap att = n.getAttributes();
	            int nbAtt = att.getLength();

	            //nous parcourons tous les noeuds pour les afficher
	            for(int j = 0; j < nbAtt; j++){
	               Node noeud = att.item(j);
	               
	               //On r�cup�re le nom de l'attribut et sa valeur gr�ce � ces deux m�thodes
	               DefaultMutableTreeNode attribut = new DefaultMutableTreeNode ("ATTRIBUT : " + noeud.getNodeName() + "=" + noeud.getNodeValue());
	               treeNode.add(attribut);
	            }
	         }

	         int nbChild = n.getChildNodes().getLength();
	         NodeList list = n.getChildNodes();

	         for(int i = 0; i < nbChild; i++){
	            Node n2 = list.item(i);

	            if (n2 instanceof Element){

	               DefaultMutableTreeNode noeud = new DefaultMutableTreeNode(n2.getNodeName());

	               if(n2.getTextContent() != null && n2.getTextContent().trim() != "" && n2.getChildNodes().getLength() == 1){

	                  DefaultMutableTreeNode value = new DefaultMutableTreeNode("VALEUR : " + n2.getTextContent());

	                  noeud.add(value);

	               }    

 	               createJTree(n2, noeud); //appel r�cursif � la m�thode pour le traitement du noeud et de ses enfants

	               treeNode.add(noeud);
	            }            
	         }
	      }
	   }   
}

