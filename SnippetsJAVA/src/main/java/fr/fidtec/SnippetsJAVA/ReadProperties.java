package fr.fidtec.SnippetsJAVA;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
 
public class ReadProperties {
 
    private final static String NOM_FICHIER_COMPLET_PROPERTIES =  "src/main/resources/MesProprietes.properties";
    private final static String NOM_FICHIER_SIMPLE_PROPERTIES = "MesProprietes.properties";
    private final static String NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION = "MesProprietes";
    
    /**
     * Charge la liste des propriétés contenu dans le fichier spécifié
     *
     * @param filename le fichier complet contenant les propriétés
     * @return un objet Properties contenant les propriétés du fichier
     */
    public static Properties loadPropertiesWithStream(String filename) throws IOException, FileNotFoundException{
    	Properties properties = new Properties();

    	FileInputStream input = new FileInputStream(filename);
   
	    try {
	      properties.load(input);
	      return properties;
	    }
	
	    finally {
	       input.close();
	    }

    }
    
    /**
     * Charge la liste des propriétés contenu dans le fichier spécifié
     *
     * @param filename le fichier simple contenant les propriétés
     * @return un objet Properties contenant les propriétés du fichier
     */
    public static Properties loadPropertiesWithClassLoader(String filename) throws IOException {
    	Properties resultats = new Properties(); 
    	resultats.load(ClassLoader.getSystemResourceAsStream(filename)); 
    	return resultats;
    }
    
    /**
     * Charge la liste des propriétés contenu dans le fichier spécifié avec ResourceBundle
     * 
     * The java.util.ResourceBundle is a library used for internationalization (multiple languages)
     *
     * @param filename le fichier simple sans extension contenant les propriétés (par exemple, MesProprietes_fr_FR)
     * @return un objet Properties contenant les propriétés du fichier
     */
    public static void showPropertiesWithResourceBundle(String filename) throws IOException {
    	System.out.println("Current Locale: " + Locale.getDefault());
    	ResourceBundle mybundle = ResourceBundle.getBundle(filename);
    	System.out.println("Nom : "+ mybundle.getString("Nom"));
        System.out.println("Prénom : "+ mybundle.getString("Prenom"));
      //  System.out.println("Adresse : "+ mybundle.getString("Adresse")); // provoque une erreur
    }
    
    /**
    * Affiche les propriétés présentes 
    * 
    *  @param properties les propriétés à afficher
    **/
    public static void showProperties(Properties properties)  {
    	 // Affichage des propriétés
        System.out.println("Nom : "+ properties.getProperty("Nom", "vide"));
        System.out.println("Prénom : "+ properties.getProperty("Prenom", "vide"));
        System.out.println("Adresse : "+ properties.getProperty("Adresse", "vide"));
    }
    
    public static void main(String[] args) {
                
    	Properties properties;
    	
        try {

        	 // Prend le classLoader du thread courant
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> enumFichiers = classLoader.getResources(NOM_FICHIER_SIMPLE_PROPERTIES);
            
            if (null != enumFichiers && enumFichiers.hasMoreElements()) {
                	URL fichierTrouve = (URL) enumFichiers.nextElement();
                	System.out.println("Fichier properties trouvé : " + fichierTrouve.toString());
            }
            
        	properties = loadPropertiesWithStream(NOM_FICHIER_COMPLET_PROPERTIES); 
            showProperties(properties);
                 
            properties = loadPropertiesWithClassLoader(NOM_FICHIER_SIMPLE_PROPERTIES); 
            showProperties(properties);
            
            showPropertiesWithResourceBundle(NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION);
                 
            Locale.setDefault(new Locale("en", "US", "CDN")); // langue, pays
            showPropertiesWithResourceBundle(NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION);
            
         } catch (Exception e) {
                     e.printStackTrace();
         }
     }
 
}