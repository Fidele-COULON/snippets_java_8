package fr.fidtec.snippets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.fidtec.enums.enumLANDING_SDT;

public class Enum_Test {

	@Test
	public void useCase1() {
		System.out.println("Lancement du test");
		System.out.println(enumLANDING_SDT.CLIENT.getDomainName() + " = " + enumLANDING_SDT.CLIENT.getSdt());	
		assertEquals("SDT_CLIENT", enumLANDING_SDT.CLIENT.getSdt());
	}

}
