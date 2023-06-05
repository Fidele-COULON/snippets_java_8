package fr.fidtec.SnippetsJAVA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsJava {

	// https://waytolearnx.com/2020/04/java-stream-map.html
	
	public static void streamList() {
		
        //Créer une liste des entiers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        
        // incrémenter et afficher les éléments de la liste
        list.stream().map(x -> x + 1)
        		     .forEach(System.out::println);
        
	}
	
	public static void streamtoMAJ() {
		
        //Créer une liste des strings
        List<String> liste = Arrays.asList("a", "b", "c", "waytolearnx");
        
        // convertir des minuscules en majuscules
        // Java Stream collect() effectue une opération de réduction mutable sur les éléments du flux. Il s’agit d’une opération terminal.
        List<String> res = liste.stream()
                                .map(String::toUpperCase)
                                .collect(Collectors.toList()); 
  
        // afficher le nouveau stream 
        System.out.println(res); 
        
	}

	public static void main(String[] args) {
		streamList();
		
		streamtoMAJ();

	}

}
