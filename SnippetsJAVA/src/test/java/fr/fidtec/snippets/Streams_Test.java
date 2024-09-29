package fr.fidtec.snippets;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

//https://waytolearnx.com/2020/04/java-stream-map.html

public class Streams_Test {

	@Test
	public void useCase1() {
		
        // Créer une liste des entiers
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        
        // Incrémenter et afficher les éléments de la liste
        integerList.stream()
                   .map(x -> x + 1)
        		   .forEach(System.out::println);
        
        assertTrue(true);
        
	}
	
	@Test
	public void useCase2() {
		
        // Créer une liste des strings
        List<String> stringList = Arrays.asList("a", "b", "c", "waytolearnx");
        
        // Convertir des minuscules en majuscules
        // Java Stream collect() effectue une opération de réduction mutable sur les éléments du flux. Il s’agit d’une opération terminal.
        List<String> resultat = stringList.stream()
                                          .map(String::toUpperCase)
                                          .collect(Collectors.toList()); 
  
        // Afficher le nouveau stream 
        System.out.println(resultat); 
        
        assertTrue(true);
        
	}

}
