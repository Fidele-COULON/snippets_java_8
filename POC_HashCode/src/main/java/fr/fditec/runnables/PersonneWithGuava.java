package fr.fditec.runnables;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

// Guava est une bibliothèque créée par Google
// Guava et Commons Lang ont deux approches différentes.
// Guava propose principalement l'objet « Objects » dont les méthodes réalisent des fonctionnalités variées alors
// que Commons Lang préfère proposer plusieurs objets pour réaliser les mêmes opérations. 

//  Apache avait été un précurseur sur le sujet, mais s'était fait plus discret au passage à Java 5 (en particulier sur les generics)
// Google, quant à lui, est relativement actif et Guava est un peu plus à la mode que Commons Lang.
// Les deux bibliothèques remplissent le contrat de façon équivalente.
// Le choix de l'un ou de l'autre sera une question de goût ou de mode …
// il y a un très large consensus en faveur de Guava. 

public class PersonneWithGuava implements Comparable<PersonneWithGuava>  {

	private String nom;
	private String prenom;
	private int age;
	
	 @Override
	 public boolean equals(Object obj) {

	       if (this == obj) return true;
	       if (obj == null) return false;
	       if (! (obj instanceof PersonneWithGuava)) return false;

	       PersonneWithGuava other = (PersonneWithGuava) obj;

	       return Objects.equal(nom, other.nom)
	              && Objects.equal(prenom, other.prenom)
	              && Objects.equal(age, other.age);
	 }
	 
	 @Override
	 public int hashCode() {
	       return Objects.hashCode(nom, prenom, age);
	 }
	 
	 @Override
	 public String toString() {
	       return Objects.toStringHelper(this)
	               .add("nom", nom)
	               .add("prenom", prenom)
	               .add("age", age)
	               .toString();
	 }
	 
	 @Override
	 public int compareTo(PersonneWithGuava other) {
	       return ComparisonChain.start()
	               .compare(nom, other.nom)
	               .compare(prenom, other.prenom)
	               .compare(age, other.age)
	               .result();
	 }
}
