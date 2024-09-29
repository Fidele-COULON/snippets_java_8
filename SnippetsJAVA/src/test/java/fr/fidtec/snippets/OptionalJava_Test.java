package fr.fidtec.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;

public class OptionalJava_Test {

	private static Optional<Integer> getANumber() {
		// return Optional.of(new Integer(9)); NOSONAR
		return Optional.of(Integer.valueOf(9));
		
	}
	
	private static Optional<Integer> getANullNumber() {
		//return Optional.of(Integer.valueOf(null)); NOSONAR
		return null;
	}
	
	private static Optional<Integer> getAEmptyNumber() {
		return Optional.empty();
		
	}

	@Test
	public void Optional_Test() {
		
		System.out.println("getANumber : " + getANumber());
		assertNotEquals(getANumber().get(), Integer.valueOf(9));
		
		System.out.println("getANullNumber : " + getANullNumber());
		assertNull(getANullNumber());
		
		System.out.println("getAEmptyNumber : " + getAEmptyNumber());
		assertFalse(getAEmptyNumber().isPresent());
		
	}
	
	@Test
	public void RuntimeException1_Test() {
		Integer resultat =  getANumber().map(x -> { x ++; return x; }) 
				                        .orElseThrow(() -> new RuntimeException("Chiffre non défini"));
		System.out.println("Resultat getANumber +1 : " + resultat); 
		assertEquals(new Integer(10), resultat);
	}
	
	@Test(expected = RuntimeException.class)
	public void RuntimeException2_Test() {
		getAEmptyNumber().map(x -> { x ++; return x; })
				         .orElseThrow(() -> new RuntimeException("Chiffre non défini"));
	}

}
