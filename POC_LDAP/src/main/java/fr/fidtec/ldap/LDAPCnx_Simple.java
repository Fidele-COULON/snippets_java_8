package fr.fidtec.ldap;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPCnx_Simple {

	public static DirContext getLDAPContexte(String url, String login, String pass ) throws NamingException {

			//On remplis un tableau avec les parametres d'environement et de connexion au LDAP
			Hashtable <String, Object> environnement = new Hashtable <String, Object>(); // NOSONAR
			
			environnement.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			environnement.put(Context.PROVIDER_URL, url);
			environnement.put(Context.SECURITY_AUTHENTICATION, "simple");
			environnement.put(Context.SECURITY_PRINCIPAL, login);
			environnement.put(Context.SECURITY_CREDENTIALS, pass);
			
			environnement.put("com.sun.jndi.ldap.trace.ber", System.err);
			
			return new InitialDirContext(environnement);
	}
	
}


