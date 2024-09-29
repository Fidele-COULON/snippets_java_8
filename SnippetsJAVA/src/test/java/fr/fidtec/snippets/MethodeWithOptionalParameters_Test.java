package fr.fidtec.snippets;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class MethodeWithOptionalParameters_Test {

	private int callMe(Object... o) {
		System.out.println("Lancement de callMe");
		
		Stream.of(o).forEach(System.out::println);
		
		return o.length;
	}
	
	@Test
	public void useCase1() {
		assertEquals(1, callMe("Coucou"));
	}
	
	@Test
	public void useCase2() {
		assertEquals(2, callMe("Coucou", "Salut"));
	}
	
	@Test
	public void useCase3() {
		assertEquals(3, callMe("Coucou", "Salut", "Au revoir"));
	}
	
}
