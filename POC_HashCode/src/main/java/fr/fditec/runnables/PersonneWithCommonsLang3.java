package fr.fditec.runnables;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonneWithCommonsLang3 implements Comparable<PersonneWithCommonsLang3> {

	private String nom;
	private String prenom;
	private int age;
	
	@Override
    public int hashCode() {
       return new HashCodeBuilder(17, 37) 
           .append(nom) 
           .append(prenom) 
           .append(age) 
           .toHashCode();
    }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		PersonneWithCommonsLang3 other = (PersonneWithCommonsLang3) obj;
		 return new EqualsBuilder()  
			        .append(nom, other.nom) 
			        .append(prenom, other.prenom) 
			        .append(age, other.age) 
			        .isEquals();
	}
	
	 @Override
	 public String toString() {
	       return new ToStringBuilder(this) 
	       .append("nom", nom) 
	       .append("prenom", prenom) 
	       .append("age", age) 
	       .toString();
	 }
	 
	 @Override
	 public int compareTo(PersonneWithCommonsLang3 other) {
	       return new CompareToBuilder() 
	       .append(nom, other.nom) 
	       .append(prenom, other.prenom) 
	       .append(age, other.age) 
	       .toComparison();
	 }
}
