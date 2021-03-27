package fr.fidtec.heritage;

public class Commercial extends Utilisateur {
	private String Matricule;
	
	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	@Override
	public void disBonjour() {
		System.out.println("Bonjour !!!!");
	}
	
	@Override
	public String toString() {
		return "Utilisateur [nom=" + super.getNom() + ", prenom=" + super.getPrenom() + "]";
	}
	
}
