package fr.fidtec.ldap;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import static fr.fidtec.ldap.Constants.*;

public class LDAPCnx_Kerberos {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
			
		System.setProperty("sun.security.krb5.debug", "true");
		System.setProperty("java.security.auth.login.config", "C:/Temp/gsseg_jaas.conf");
		System.setProperty("java.security.krb5.conf", "C:/Windows/krb5.ini");
        System.setProperty("java.security.krb5.realm","FIDTEC.FR");
        System.setProperty("java.security.krb5.kdc", "MARSDC2019.FIDTEC.FR");
       // System.setProperty("javax.security.auth.useSubjectCredsOnly","false");
        
		//On remplis un tableau avec les parametres d'environement et de connexion au LDAP
		Hashtable <String, Object> environnement = new Hashtable <String, Object>(); // NOSONAR
		
		environnement.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environnement.put(Context.PROVIDER_URL, SERVER_LDAP_URI);
		environnement.put(Context.SECURITY_AUTHENTICATION, "GSSAPI");
		// environnement.put("javax.security.sasl.server.authentication", "true");
		 
		environnement.put(Context.SECURITY_PRINCIPAL, SERVER_LOGIN);
		environnement.put(Context.SECURITY_CREDENTIALS, SERVER_PASS);
		
		// environnement.put("com.sun.jndi.ldap.trace.ber", System.err);
		// environnement.put("java.naming.security.sasl.realm", "FIDTEC.FR");
		//environnement.put( "javax.security.sasl.qop", "auth-conf" );
		
		// Request medium-strength cryptographic protection
		// environnement.put("javax.security.sasl.strength", "high");
		
		try {
			
			//On appelle le contexte à partir de l'environnement
			DirContext contexte = new InitialDirContext(environnement);
			
			// Si ça ne plante pas c'est que la connexion est faite
			System.out.println("Connexion au serveur : SUCCES");
			
			try {
				// On recupere l'attribut de Fidele COULON
				Attributes attrs = contexte.getAttributes("CN=Fidele COULON,CN=Users,DC=fidtec,DC=fr");
				System.out.println("Recuperation de Fidele : SUCCES");
				
				// On affiche le nom complet
				System.out.println(attrs.get("name"));
				
				// On affiche le mail
				System.out.println(attrs.get("mail"));
				
				// On affiche le compte SAM associé 
				System.out.println(attrs.get("sAMAccountName"));

			} catch (NamingException e) {
				System.out.println("Recuperation de Fidele : ECHEC");
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			System.out.println("Connexion au serveur : ECHEC");
			e.printStackTrace();
		}
	}
}


