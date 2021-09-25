package fr.fidtec.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Personne_Test {

	@Test
	public void PersonneTest() {
		SamplePersonne p = new SamplePersonne();
		
		p.setNom("COULON");
		p.setPrenom("Fidele");
	
		assertEquals("COULON", p.getNom());
		assertEquals("Fidele", p.getPrenom());
		
		System.out.println(p.toString());
	}
}
