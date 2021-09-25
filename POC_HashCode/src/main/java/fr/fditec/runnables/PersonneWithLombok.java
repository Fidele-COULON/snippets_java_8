package fr.fditec.runnables;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// L'annotation « @Data » fonctionne comme l'addition des annotations « @Getter », « @Setter », « @ToString », « @EqualsAndHashCode » et « @RequiredArgsConstructor ». 
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@EqualsAndHashCode(exclude = { "description" })
@ToString
public class PersonneWithLombok {

	private String nom;
	private String prenom;
	private int age;
	private String description;
	
}
