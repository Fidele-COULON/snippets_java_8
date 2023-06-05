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

public class LDAPCnx_Simple {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

			
			//On remplis un tableau avec les parametres d'environement et de connexion au LDAP
			Hashtable <String, Object> environnement = new Hashtable <String, Object>(); // NOSONAR
			
			environnement.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			environnement.put(Context.PROVIDER_URL, SERVER_LDAP_URI);
			environnement.put(Context.SECURITY_AUTHENTICATION, "simple");
			environnement.put(Context.SECURITY_PRINCIPAL, SERVER_LOGIN);
			environnement.put(Context.SECURITY_CREDENTIALS, SERVER_PASS);
			
			environnement.put("com.sun.jndi.ldap.trace.ber", System.err);
			
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


