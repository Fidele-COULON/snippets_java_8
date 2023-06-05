package fr.fidtec.ldap;

public class Constants {

	private Constants() {} // pour empêcher l'instanciation
	
	// URI du serveur LDAP
	public static final String SERVER_LDAP_URI = "ldap://192.168.1.4:389/";
		
	// Login de connexion à l'annuaire LDAP : DN ou Domaine\User ou Login AD
	// public static final String serverLogin = "CN=LDAPUser,CN=Users,DC=FIDTEC,DC=fr"; // ou FIDTEC\\LDAPUser ou userLDAP@fidtec.fr
	// public static final String serverLogin = "FIDTEC\\LDAPUser"; // LdapErr: DSID-0C090569
	public static final String SERVER_LOGIN = "FIDTEC\\LDAPUser"; 
	public static final String SERVER_PASS = "Secret2021.";
}
