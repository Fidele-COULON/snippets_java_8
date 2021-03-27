package fr.fidtec.heritage;

public class Parent {
	
	private String nom;
	private String prenom;
		
	public Parent(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Parent [Nom=" + nom + ", Prenom=" + prenom + "]";
	}
	
}
