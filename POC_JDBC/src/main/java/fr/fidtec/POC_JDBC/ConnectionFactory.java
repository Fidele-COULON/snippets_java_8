package fr.fidtec.POC_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static final String URL = "url";
	private static final String USER = "user";
	private static final String PASSWD ="passwd";
	private static final String VIDE ="vide";
	private static final String PROPERTIES = ".properties";
	
    private Connection connection = null;
    
    protected Connection getConnection() {
		return this.connection;
	}

	protected ConnectionFactory(EnumDB enumDB) {
		
		connection = null;
		
		try {      
        	
        	// Lecture des propriétés de connexion
        	Properties properties = new Properties();
    		
        	String connectionConfigurationFile = enumDB.getDatabaseName() + PROPERTIES;
    		
        	System.out.println("Using Conf File " +  connectionConfigurationFile);
        	
    		properties.load(ClassLoader.getSystemResourceAsStream(connectionConfigurationFile)); // nom simple        
             
    		String url = properties.getProperty(URL, VIDE);
    		System.out.println("URL : " + url);
    		
    		// With modern JDBC drivers and a current JDK (at least Java 6) the call toClass.forName() is no longer necessary
    		// Le chargement explicite est inutile à partir de JDBC 4.
    		
            // Open a connection
    		if (enumDB.getUseCredentials().booleanValue()) {
        		String user = properties.getProperty(USER, VIDE);
        		String passwd = properties.getProperty(PASSWD, VIDE);
        		connection = DriverManager.getConnection(url, user, passwd);
    		} else {			
    			connection = DriverManager.getConnection(url);
    		}
    		
            System.out.println("Connexion effectuée !");
            
        } catch (Exception e) {
        	 e.printStackTrace();
        }
		
	}
}
