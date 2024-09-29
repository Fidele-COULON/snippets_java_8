package fr.fidtec.ldap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.junit.Test;

public class LDAPCnx_Test {
	
	private static final String SERVER_LDAP_URI = "ldap://172.18.174.104:389/";
	private static final String SERVER_LOGIN = "cn=admin,dc=fidtec,dc=fr"; 
	private static final String SERVER_PASS = "root";
	
	private static final String EXISTING_USER = "uid=fidele.coulon,OU=People, DC=fidtec,DC=fr";
	
	private static final String NOT_EXISTING_USER = "uid=BAD_USER,OU=People, DC=fidtec,DC=fr";
	
	@Test
	public void getLDAPContexte_Test() throws NamingException {
		DirContext contexte = LDAPCnx_Simple.getLDAPContexte(SERVER_LDAP_URI, SERVER_LOGIN, SERVER_PASS);
		assertNotNull(contexte);
	}
	
	@Test
	public void getLDAPObject_OK() throws NamingException {
		DirContext contexte = LDAPCnx_Simple.getLDAPContexte(SERVER_LDAP_URI, SERVER_LOGIN, SERVER_PASS);
		Attributes attrs = contexte.getAttributes(EXISTING_USER);
		System.out.println("Recuperation de Fidele : SUCCES");		
		assertNotNull(attrs);
	}
	
	@Test
	public void getLDAPObject_KO() throws NamingException {
		DirContext contexte = LDAPCnx_Simple.getLDAPContexte(SERVER_LDAP_URI, SERVER_LOGIN, SERVER_PASS);
		Attributes attrs = contexte.getAttributes(NOT_EXISTING_USER);
		assertNotNull(attrs);
	}
	
	@Test
	public void getLDAPSearch_OK() throws NamingException {
		DirContext contexte = LDAPCnx_Simple.getLDAPContexte(SERVER_LDAP_URI, SERVER_LOGIN, SERVER_PASS);
		
		String baseDN = "OU=People, DC=fidtec,DC=fr";

	    SearchControls sc = new SearchControls();
	    String[] attributeFilter = { "cn", "mail" };
	    sc.setReturningAttributes(attributeFilter);
	    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

	    String filter = "(&(sn=W*)(l=Criteria*))";
		
	    NamingEnumeration<SearchResult> results = contexte.search(baseDN, filter, sc);
	    
	    while (results.hasMore()) {
	      SearchResult sr = (SearchResult) results.next();
	      Attributes attrs = sr.getAttributes();

	      Attribute attr = attrs.get("cn");
	      System.out.print(attr.get() + ": ");
	      attr = attrs.get("mail");
	      System.out.println(attr.get());
	    }
	    
	    assertTrue(true);
	}
	
}
