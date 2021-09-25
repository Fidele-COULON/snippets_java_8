package fr.fidtec.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class PersonneWithDetails {
	@Getter @Setter
	private String nom;
	
	@Getter @Setter
	private String prenom;
		
}
