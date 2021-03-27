package fr.fidtec.SnippetsJAVA;

public enum enumLANDING_SDT {

	 CLIENT("CLIENT","SDT_CLIENT"),

	 PROSPECT("PROSPECT","SDT_PROSPECT"),

	 ENTREPRISE ("ENTREPRISE","SDT_ENTREPRISE"),

	 ENTREPRISEPROSPECT ("ENTREPRISEPROSPECT","SDT_ENTREPRISEPROSPECT");
	   
     private String domainName = "";

     private String SDT = "";	   

	 // Constructeur, est appellé lors de la première demande, un import static ne déclenche pas le constructeur
     private enumLANDING_SDT(String domainName, String SDT){
    	System.out.println("Constructeur enumLANDING_SDT");
		this.domainName = domainName;
	    this.SDT = SDT;
	 }


     public String getDomainName(){
    	 return domainName;
	 }

	 public String getSDT(){
	    return SDT;
	 }
}
