package fr.fidtec.POC_JDBC;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

public class PostGre_ReadPropertiesTest {
	
	private static final String DB_NAME = "PostGre";	
	private static final String PROPERTIES_FILE_NAME = DB_NAME + ".properties";
	
	@Test
	public void readFile() throws IOException {
		Properties properties = new Properties();
		
		properties.load(ClassLoader.getSystemResourceAsStream(PROPERTIES_FILE_NAME)); // nom simple        
         
		String url=properties.getProperty("url", "vide");
		String user=properties.getProperty("user", "vide");
		String passwd=properties.getProperty("passwd", "vide");
				
         // Affichage des propriétés
		 System.out.println("URL : "+ url);
		 System.out.println("User : "+ user);
         System.out.println("pass : "+ passwd);
              
         assertTrue("jdbc:postgresql://192.168.1.3:5432/dev".equals(url));
         assertTrue("postgres".equals(user));
         assertTrue("admin".equals(passwd));
        	 
	}

}
