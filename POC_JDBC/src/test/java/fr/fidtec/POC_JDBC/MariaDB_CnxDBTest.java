package fr.fidtec.POC_JDBC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import static fr.fidtec.POC_JDBC.DBConnection_Utils.*;

public class MariaDB_CnxDBTest {

	private final static String URL = "jdbc:mysql://192.168.1.3:3306/test";
	private final static String USER = "root";
	private final static String PASS ="root";
	private final static String TOTO ="toto";
	 
	@Test
	public void getCnxDB_Raw_withGoodCreds() {			
		try {      
	     		 		
	        @SuppressWarnings("unused")
			Connection connect = DriverManager.getConnection(URL, USER, PASS);
	        System.out.println("getCnxDBwithGoodCreds - Connexion effectuée !");
	        assertTrue(true);
	         
	    } catch (Exception e) {
	    	 System.out.println("getCnxDBwithGoodCreds - Erreur DBConnexion : " + e.getMessage());
	    	 e.printStackTrace();
	     	assertTrue(false);
	    }	 
	}
	
	@Test(expected=SQLException.class)
	public void getCnxDB_Raw_withBadCreds() throws Exception {
        @SuppressWarnings("unused")
		Connection connect = DriverManager.getConnection(URL, TOTO, TOTO);
        System.out.println("getCnxDBwithBadCreds - Connexion effectuée !");
	}
	
	@Test
	public void showUsers() throws SQLException {
		
        Statement stmt  = MariaDB_Connection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = stmt.executeQuery(SQL_SELECT);

        assertNotNull(rs);
        
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
    }
	
	@Test
	public void createUser() throws SQLException {

		final String nom = "COULON2";
		final String prenom = "Fidele";
		
        PreparedStatement prepare  = MariaDB_Connection.getConnection().prepareStatement(SQL_INSERT);

        prepare.setString(1, nom);
        prepare.setString(2, prenom);

        int resultat = prepare.executeUpdate();
        
        System.out.println("Création :" + resultat);

        prepare.close();

        assertEquals(1, resultat);
    }
	
}
