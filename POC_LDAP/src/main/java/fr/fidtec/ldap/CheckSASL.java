package fr.fidtec.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import static fr.fidtec.ldap.Constants.*;

public class CheckSASL {

	public static void main(String[] args) {
			
		//On remplis un tableau avec les parametres d'environement et de connexion au LDAP
		Hashtable <String, Object> environnement = new Hashtable <String, Object>(); // NOSONAR
		
		environnement.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		environnement.put(Context.PROVIDER_URL, SERVER_LDAP_URI);
		environnement.put(Context.SECURITY_AUTHENTICATION, "simple");		 
		environnement.put(Context.SECURITY_PRINCIPAL, SERVER_LOGIN);
		environnement.put(Context.SECURITY_CREDENTIALS, SERVER_PASS);

		try {
		    // Create initial context
		    DirContext ctx = new InitialDirContext(environnement);

		    // Read supportedSASLMechanisms from root DSE
		    Attributes attrs = ctx.getAttributes(SERVER_LDAP_URI, new String[]{"supportedSASLMechanisms"});

		    System.out.println(attrs); //NOSONAR {supportedsaslmechanisms=supportedSASLMechanisms: GSSAPI, GSS-SPNEGO, EXTERNAL, DIGEST-MD5} avec AD 2019

		    // Close the context when we're done
		    ctx.close();
		} catch (NamingException e) {
		    e.printStackTrace();
		}
	}
}
