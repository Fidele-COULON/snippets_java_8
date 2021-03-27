package fr.fidtec.POC_JDBC;

public class DBConnection_Utils {

	private DBConnection_Utils() {}
	
	public final static String SQL_SELECT = "SELECT id, nom, prenom FROM utilisateurs";
	
	public final static String SQL_INSERT = "INSERT INTO utilisateurs (nom, prenom) VALUES(?,?)";
	
	public final static String SQL_CREATE_TABLE = "CREATE TABLE utilisateurs(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(255), prenom  VARCHAR(255));";
}
