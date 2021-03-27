package fr.fidtec.POC_JDBC;

import java.sql.Connection;

public class H2DB_Connection {
	
	private static final ConnectionFactory instance = new ConnectionFactory(EnumDB.H2);
		
	private H2DB_Connection() {} // pour rendre la classe non instanciable
	
    public static Connection getConnection(){
          return instance.getConnection();
    }
}
