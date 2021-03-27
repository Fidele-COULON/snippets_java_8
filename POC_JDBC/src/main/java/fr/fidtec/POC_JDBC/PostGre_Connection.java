package fr.fidtec.POC_JDBC;

import java.sql.Connection;

public class PostGre_Connection {

	private static final ConnectionFactory instance = new ConnectionFactory(EnumDB.POSTGRE);

	private PostGre_Connection() {} // pour rendre la classe non instanciable
	
    public static Connection getConnection(){
        return instance.getConnection();
    }
    
}
