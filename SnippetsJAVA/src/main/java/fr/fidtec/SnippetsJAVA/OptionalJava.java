package fr.fidtec.SnippetsJAVA;

import java.util.Optional;

public class OptionalJava {

	private static Optional<Integer> getANumber() {
		// return Optional.of(new Integer(9));
		return Optional.of(Integer.valueOf(9));
		
	}
	
	private static Optional<Integer> getANullNumber() {
		//return Optional.of(Integer.valueOf(null));
		return null;
	}
	
	private static Optional<Integer> getAEmptyNumber() {
		return Optional.empty();
		
	}

	public static void main(String[] args) {
		System.out.println("getANumber : " + getANumber());
		
		System.out.println("getANumber +1 : " + getANumber().map(x -> { x ++; return x; })
				.orElseThrow(() -> new RuntimeException("Chiffre non défini")));
		
		System.out.println("getANullNumber : " + getANullNumber());
		
		System.out.println("getAEmptyNumber : " + getAEmptyNumber());
		
		System.out.println("getAEmptyNumber +1 : " + getAEmptyNumber().map(x -> { x ++; return x; })
				.orElseThrow(() -> new RuntimeException("Chiffre non défini")));
	}

}
