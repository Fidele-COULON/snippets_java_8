package fr.fidtec.POC_JDBC;

import static fr.fidtec.POC_JDBC.DBConnection_Utils.SQL_INSERT;
import static fr.fidtec.POC_JDBC.DBConnection_Utils.SQL_SELECT;
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

public class PostGre_CnxDBTest {

	private final static String url="jdbc:postgresql://192.168.1.3:5432/dev";
	private final static String user="postgres";
	private final static String passwd="admin";
		
	@Test
	public void getCnxDBwithGoodCreds() {			
		try {      
	     		 		
	        @SuppressWarnings("unused")
			Connection connect = DriverManager.getConnection(url, user, passwd);
	        System.out.println("getCnxDBwithGoodCreds - Connexion effectuée !");
	        assertTrue(true);
	         
	    } catch (Exception e) {
	    	 System.out.println("getCnxDBwithGoodCreds - Erreur DBConnexion : " + e.getMessage());
	    	 e.printStackTrace();
	     	assertTrue(false);
	    }	 
	}
	
	@Test(expected=SQLException.class)
	public void getCnxDBwithBadCreds() throws Exception {
        @SuppressWarnings("unused")
		Connection connect = DriverManager.getConnection(url, "toto", "toto");
        System.out.println("getCnxDBwithBadCreds - Connexion effectuée !");
        assertTrue(true);
	}
	
	@Test
	public void showUsers() throws SQLException {
		
        Statement stmt  = PostGre_Connection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

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

		final String nom = "COULON";
		final String prenom = "Laurence";
		
        PreparedStatement prepare  = PostGre_Connection.getConnection().prepareStatement(SQL_INSERT);

        prepare.setString(1, nom);
        prepare.setString(2, prenom);

        int resultat = prepare.executeUpdate();
        
        System.out.println("Création :" + resultat);

        prepare.close();

        assertEquals(1, resultat);
    }
	
}
