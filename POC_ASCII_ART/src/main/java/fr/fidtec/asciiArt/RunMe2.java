package fr.fidtec.asciiArt;

public class RunMe2 {

	public static void main(String[] args) {

		System.out.println();
		System.out.println(ASCIIArtGenerator.printTextArt("Hello", ASCIIArtGenerator.ART_SIZE_MEDIUM));
        System.out.println();
         
        System.out.println();
    	System.out.println(ASCIIArtGenerator.printTextArt("Love is life!", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO, "@", false, 4));
        System.out.println();

        System.out.println();
    	System.out.println(ASCIIArtGenerator.printTextArt("Love is life!", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO, "@", true, 2));
        System.out.println();
	}

}
