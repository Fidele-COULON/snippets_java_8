package fr.fidtec.POC_JDBC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import static fr.fidtec.POC_JDBC.DBConnection_Utils.*;

public class H2DB_CnxDBTest {

	private final static String url="jdbc:h2:mem:";
		
	@Test
	public void getCnxDBwithGoodCreds() {			
		try {      
	     		 		
	        @SuppressWarnings("unused")
			Connection connect = DriverManager.getConnection(url);
	        System.out.println("getCnxDBwithGoodCreds - Connexion effectuée !");
	        assertTrue(true);
	         
	    } catch (Exception e) {
	    	 System.out.println("getCnxDBwithGoodCreds - Erreur DBConnexion : " + e.getMessage());
	    	 e.printStackTrace();
	     	 assertTrue(false);
	    }	 
	}
		
	@Test
	public void createAndPopulateTableUtilisateurs() throws SQLException {
		
		PreparedStatement prepare = H2DB_Connection.getConnection().prepareStatement(SQL_CREATE_TABLE);	
        prepare.executeUpdate();
        prepare.close();
        
        // createUsers
   		assertEquals(1, createUser("COULON", "Fidele"));
   		assertEquals(1, createUser("COULON", "Laurence"));
   		assertEquals(1, createUser("COULON", "Vanille"));
   		assertEquals(1, createUser("COULON", "PetitFidele"));
   		assertEquals(1, createUser("COULON", "Capucine"));
        
   		// showUsers
   		assertTrue(showUsers());
        
    }
	
	private boolean showUsers() throws SQLException {
		   
		boolean resultat = false;
		
		try {
        Statement stmt  = H2DB_Connection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
	        ResultSet rs = stmt.executeQuery(SQL_SELECT);
	        
	        // Lecture du  result set
	        while (rs.next()) {
	            //Récupération des résultats par nom de colonne
	            int id = rs.getInt("id");
	            String nom = rs.getString("nom");
	            String prenom = rs.getString("prenom");
	            System.out.println("ID: " + id + " Prenom: " + prenom + " Nom: " + nom);
	        }
	
	        // Clean-up enviroment
	        rs.close(); stmt.close();
	        
	        resultat = true;
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultat;
    }
	
	private int createUser(String nom, String prenom) throws SQLException {
		
        PreparedStatement prepare  = H2DB_Connection.getConnection().prepareStatement(SQL_INSERT);

        prepare.setString(1, nom);
        prepare.setString(2, prenom);

        int resultat = prepare.executeUpdate();
        
        System.out.println("Utilisateur créé : " + resultat);

        prepare.close();

        return resultat;
    }
}
