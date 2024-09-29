package fr.fidtec.snippets;


import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.junit.Test;
 
public class ReadProperties_Test {
 
    private static final String NOM_FICHIER_COMPLET_PROPERTIES =  "src/main/resources/MesProprietes.properties";
    private static final String NOM_FICHIER_SIMPLE_PROPERTIES = "MesProprietes.properties";
    private static final String NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION = "MesProprietes";
    
    /**
     * Charge la liste des propriétés contenue dans le fichier spécifié via un FileInputStream
     *
     * @param fullFilename le fichier complet contenant les propriétés
     * @return un objet Properties contenant les propriétés du fichier
     */
    private Properties loadPropertiesWithStream(String fullFilename) throws IOException {
    	Properties resultats = new Properties();

    	FileInputStream input = new FileInputStream(fullFilename);
   
	    try {
	    	resultats.load(input);
	    } finally {
	       input.close();
	    }

	    return resultats;
	      
    }
    
    @Test
    public void useCase1_loadPropertiesWithStream_Test() throws IOException {
    	Properties properties = loadPropertiesWithStream(NOM_FICHIER_COMPLET_PROPERTIES);
    	
    	 // Affichage des propriétés
        System.out.println("Nom : "+ properties.getProperty("Nom", "vide"));
        System.out.println("Prénom : "+ properties.getProperty("Prenom", "vide"));
        System.out.println("Adresse : "+ properties.getProperty("Adresse", "vide"));
        
        assertNotNull(properties);
    }
    
    /**
     * Charge la liste des propriétés contenue dans le fichier spécifié via getSystemResourceAsStream du ClassLoader
     *
     * @param simpleFilename le fichier simple contenant les propriétés
     * @return un objet Properties contenant les propriétés du fichier
     */
    public Properties loadPropertiesWithClassLoader(String simpleFilename) throws IOException {
    	Properties resultats = new Properties(); 
    	resultats.load(ClassLoader.getSystemResourceAsStream(simpleFilename)); 
    	return resultats;
    }
    
    @Test
    public void useCase2_loadPropertiesWithClassLoader_Test() throws IOException {
    	Properties properties = loadPropertiesWithClassLoader(NOM_FICHIER_SIMPLE_PROPERTIES); 

    	// Affichage des propriétés
        System.out.println("Nom : "+ properties.getProperty("Nom", "vide"));
        System.out.println("Prénom : "+ properties.getProperty("Prenom", "vide"));
        System.out.println("Adresse : "+ properties.getProperty("Adresse", "vide"));
        
        assertNotNull(properties);
    }
    
    
    /**
     * Charge la liste des propriétés contenue dans le fichier spécifié via getContextClassLoader du Thread courant
     *
     * @param simpleFilename le fichier simple contenant les propriétés
     * @return un objet Properties contenant les propriétés du fichier
     */
    public Properties loadPropertiesWithContextClassLoader(String simpleFilename) throws IOException {
    	Properties resultats = new Properties(); 
    	
    	 // Prend le classLoader du thread courant
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> enumFichiers = classLoader.getResources(NOM_FICHIER_SIMPLE_PROPERTIES);
        
        if (null != enumFichiers && enumFichiers.hasMoreElements()) {
            URL fichierTrouve = (URL) enumFichiers.nextElement();
            System.out.println("Fichier properties trouvé : " + fichierTrouve.toString());
            resultats.load(fichierTrouve.openStream());
        }
            
    	return resultats;
    }
    
    @Test
    public void useCase3_loadPropertiesWithContextClassLoader_Test() throws IOException {
    	Properties properties = loadPropertiesWithContextClassLoader(NOM_FICHIER_SIMPLE_PROPERTIES); 

    	// Affichage des propriétés
        System.out.println("Nom : "+ properties.getProperty("Nom", "vide"));
        System.out.println("Prénom : "+ properties.getProperty("Prenom", "vide"));
        System.out.println("Adresse : "+ properties.getProperty("Adresse", "vide"));
        
        assertNotNull(properties);
    }
    
    /**
     * Charge la liste des propriétés contenue dans le fichier spécifié avec ResourceBundle
     * 
     * The java.util.ResourceBundle is a library used for internationalization (multiple languages)
     *
     * @param filename le fichier simple sans extension contenant les propriétés (par exemple, MesProprietes)
     * @return un objet Properties contenant les propriétés du fichier
     */
    public ResourceBundle loadPropertiesWithResourceBundle(String filename) {
    	return ResourceBundle.getBundle(filename);
    }
    
    @Test
    public void useCase4_loadPropertiesWithResourceBundle_fr_FR_Test() {
    	System.out.println("Current Locale : " + Locale.getDefault());
    	
    	ResourceBundle resourceBundle = loadPropertiesWithResourceBundle(NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION);
    	
      	// Affichage des propriétés
        System.out.println("Nom : "+ resourceBundle.getString("Nom"));
        System.out.println("Prénom : "+ resourceBundle.getString("Prenom"));
        // System.out.println("Adresse : "+ resourceBundle.getString("Adresse")); provoque une erreur
        
        assertNotNull(resourceBundle);
    }
  
    @Test
    public void useCase5_loadPropertiesWithResourceBundle_en_US_Test() {
    	System.out.println("Current Locale : " + Locale.getDefault());
    	Locale.setDefault(new Locale("en", "US")); // langue, pays
    	System.out.println("Current Locale : " + Locale.getDefault());
    	
    	ResourceBundle resourceBundle = loadPropertiesWithResourceBundle(NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION);
    	
      	// Affichage des propriétés
        System.out.println("Nom : "+ resourceBundle.getString("Nom"));
        System.out.println("Prénom : "+ resourceBundle.getString("Prenom"));
        // System.out.println("Adresse : "+ resourceBundle.getString("Adresse")); provoque une erreur
        
        assertNotNull(resourceBundle);
    }
    
    @Test
    public void useCase6_loadPropertiesWithResourceBundle_en_US_DEV_Test() {
    	System.out.println("Current Locale: " + Locale.getDefault());
    	Locale.setDefault(new Locale("en", "US", "DEV")); // langue, pays, environnement (libre)
    	System.out.println("Current Locale : " + Locale.getDefault());
    	
    	ResourceBundle resourceBundle = loadPropertiesWithResourceBundle(NOM_FICHIER_SIMPLE_PROPERTIES_SANS_EXTENSION);
    	
      	// Affichage des propriétés
        System.out.println("Nom : "+ resourceBundle.getString("Nom"));
        System.out.println("Prénom : "+ resourceBundle.getString("Prenom"));
        // System.out.println("Adresse : "+ resourceBundle.getString("Adresse")); provoque une erreur
        
        assertNotNull(resourceBundle);
    }
  
 
}