package fr.fidtec.enums;

/* An enum can, just like a class, have attributes and methods.
 * The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).
   An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).*/
public enum enumLANDING_SDT {

	 CLIENT("CLIENT", "SDT_CLIENT"),

	 PROSPECT("PROSPECT", "SDT_PROSPECT"),

	 ENTREPRISE("ENTREPRISE", "SDT_ENTREPRISE"),

	 ENTREPRISEPROSPECT("ENTREPRISEPROSPECT", "SDT_ENTREPRISEPROSPECT");
	   
     private String domainName = "";

     private String sdt = "";	   

	 // Constructeur, est appellé lors de la première demande, un import static ne déclenche pas le constructeur
     private enumLANDING_SDT(String domainName, String sdt){
    	System.out.println("Constructeur enumLANDING_SDT pour " + domainName); // NOSONAR
		this.domainName = domainName;
	    this.sdt = sdt;
	 }

     public String getDomainName(){
    	 return domainName;
	 }

	 public String getSdt(){
	    return sdt;
	 }
}
