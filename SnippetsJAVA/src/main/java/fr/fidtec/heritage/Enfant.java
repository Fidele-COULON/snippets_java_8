package fr.fidtec.heritage;

public class Enfant extends Parent {

	private Parent parent;
	
	public Enfant(Parent parent, String prenom) {
		super(parent.getNom(), prenom);
		this.parent = parent;
	}
	
	public Parent getParent() {
		return parent;
	}

	@Override
	public String toString() {
		return "Enfant [getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
	}
	
}
