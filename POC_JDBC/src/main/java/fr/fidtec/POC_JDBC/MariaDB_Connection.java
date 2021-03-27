package fr.fidtec.POC_JDBC;

import java.sql.Connection;

public class MariaDB_Connection {
	
	private static final ConnectionFactory instance = new ConnectionFactory(EnumDB.MARIADB);
		
	private MariaDB_Connection() {} // pour rendre la classe non instanciable
	
    public static Connection getConnection(){
        return instance.getConnection();
    }
}
