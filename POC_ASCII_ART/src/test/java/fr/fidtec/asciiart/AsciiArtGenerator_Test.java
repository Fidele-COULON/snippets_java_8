package fr.fidtec.asciiart;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AsciiArtGenerator_Test {

	@Test
	public void useCase1() {
		System.out.println(AsciiArtGenerator.printTextArt("Hello", AsciiArtGenerator.ART_SIZE_MEDIUM));
		assertTrue(true);
	}
     
	@Test
	public void useCase2() {
		System.out.println(AsciiArtGenerator.printTextArt("Love is life!", AsciiArtGenerator.ART_SIZE_SMALL, AsciiArtFont.ART_FONT_MONO, "@", false, 4));
		assertTrue(true);
	}
	
	@Test
	public void useCase3() {
		System.out.println(AsciiArtGenerator.printTextArt("Love is life!", AsciiArtGenerator.ART_SIZE_SMALL, AsciiArtFont.ART_FONT_MONO, "@", true, 2));
		assertTrue(true);
	}
}
