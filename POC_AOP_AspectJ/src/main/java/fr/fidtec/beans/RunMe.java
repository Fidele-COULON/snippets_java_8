package fr.fidtec.beans;

public class RunMe {

	// Basé sur https://www.baeldung.com/aspectj
	
	public static void main(String[] args) {
		Compteur compteur = new Compteur();
		
		System.out.println(compteur.getValeur()); //NOSONAR
		
		compteur.inc();
		System.out.println(compteur.getValeur()); //NOSONAR

		compteur.dec();
		System.out.println(compteur.getValeur()); //NOSONAR
		
		compteur.inc(5);
		System.out.println(compteur.getValeur()); //NOSONAR
		
		compteur.dec(3);
		System.out.println(compteur.getValeur()); //NOSONAR
	}

}
