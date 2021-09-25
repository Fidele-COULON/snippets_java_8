package fr.fditec.runnables;

public class PersonneGeneratedByEclipse implements Comparable<PersonneGeneratedByEclipse> {

	private String nom;
	private String prenom;
	private int age;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonneGeneratedByEclipse other = (PersonneGeneratedByEclipse) obj;
		if (age != other.age)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public PersonneGeneratedByEclipse setNom(String nom) {
		this.nom = nom;
		return this;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public PersonneGeneratedByEclipse setPrenom(String prenom) {
		this.prenom = prenom;
		return this;
	}
	
	public int getAge() {
		return age;
	}
	
	public PersonneGeneratedByEclipse setAge(int age) {
		this.age = age;
		return this;
	}

	@Override
	public String toString() {
		return "PersonneWithHashCodeGeneratedByEclipse [nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}
	
	// La méthode « compareTo » est indispensable lorsqu'on a besoin de comparer des beans en Java, par exemple pour trier des listes
	// Eclipse ne propose pas de fonction de génération de code pour cette méthode
	
	 @Override
     public int compareTo(PersonneGeneratedByEclipse other) {
       int result = 0;

       result = nom.compareTo(other.nom);
       if (result != 0) {
           return result;
       }

       result = prenom.compareTo(other.prenom);
       if (result != 0) {
           return result;
       }

       result = new Integer(age).compareTo(other.age);
       if (result != 0) {
           return result;
       }
       
       return result;
	 }
}
