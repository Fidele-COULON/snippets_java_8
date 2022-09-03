package fr.fidtec.SnippetsJAVA;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter
@EqualsAndHashCode
@ToString
public class User {

	private String nom;
	private String prenom;
	
}
