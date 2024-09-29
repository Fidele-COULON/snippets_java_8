package fr.fidtec.beans;

import lombok.Data;

// L'annotation @Data de Lombok est une annotation de commodité regroupant les annotations
// @ToString, @EqualsAndHashCode, @Getter, @Setter et @RequiredArgsConstructor.
public @Data class SamplePersonne {

  private String nom;
  private String prenom;
		
}
