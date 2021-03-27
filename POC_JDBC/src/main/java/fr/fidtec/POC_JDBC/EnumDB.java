package fr.fidtec.POC_JDBC;

public enum EnumDB {

	GENERIC("GENERIC", Boolean.FALSE),
	H2("H2DB", Boolean.FALSE),
	MARIADB("MARIADB", Boolean.TRUE),
	POSTGRE("POSTGRE", Boolean.TRUE);
	
	private String databaseName;
	private Boolean useCredentials;
	
	private EnumDB(String databaseName, Boolean useCredentials) {
		this.databaseName = databaseName;
		this.useCredentials = useCredentials;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public Boolean getUseCredentials() {
		return useCredentials;
	}
}
