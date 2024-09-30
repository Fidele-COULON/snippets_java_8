package fr.fidtec.asciiart;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AsciiArtGenerator {

	private AsciiArtGenerator() {} // pour éviter l'instanciation
	
	public static final int ART_SIZE_SMALL = 12;
    public static final int ART_SIZE_MEDIUM = 18;
    public static final int ART_SIZE_LARGE = 24;
    public static final int ART_SIZE_HUGE = 32;
    
    private static final String DEFAULT_ART_SYMBOL = "*";
    
    private static final String ESPACE = " ";
    
    /**
     * Convenience method for printing ascii text art.
     * Font default - Dialog,  Art symbol default - *
     * @param artText
     * @param textHeight
     * @throws Exception
     */
    public static String printTextArt(String artText, int textHeight) {
        return printTextArt(artText, textHeight, AsciiArtFont.ART_FONT_DIALOG, DEFAULT_ART_SYMBOL, false, 0);
    }
 
    /**
     * Prints ASCII art for the specified text. For size, you can use predefined sizes or a custom size.
     * Usage - printTextArt("Hi", 30, ASCIIArtFont.ART_FONT_SERIF, "@");
     * @param artText
     * @param textHeight - Use a predefined size or a custom type
     * @param fontType - Use one of the available fonts
     * @param artSymbol - Specify the character for printing the ascii art
     * @throws Exception
     */
    public static String printTextArt(String artText, int textHeight, AsciiArtFont fontType, String artSymbol, boolean inversion, int paddingChar) {
        
    	// paddingChar 
    	String padding = new String(new char[paddingChar]).replace('\0', ' ');
    	artText = padding + artText + padding;
    			
    	String fontName = fontType.getValue();
        int imageWidth = findImageWidth(textHeight, artText, fontName);
 
        BufferedImage image = new BufferedImage(imageWidth, textHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Font font = new Font(fontName, Font.BOLD, textHeight);
        g.setFont(font);
 
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawString(artText, 0, getBaselinePosition(g, font));
 
        StringBuilder resultat = new StringBuilder();
        
        for (int y = 0; y < textHeight; y++) {
           
        	StringBuilder sb = new StringBuilder();
            
            for (int x = 0; x < imageWidth; x++) {
                
		    	if (inversion) {
		    		sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? ESPACE : artSymbol); // en noir sur fond blanc
		    	} else {
		    		sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? artSymbol : ESPACE); // en blanc sur fond de artChar
		    	}
	            
            }
            
            resultat.append(sb.toString());
            resultat.append(System.getProperty("line.separator"));
        }
        
        return resultat.toString();
    }
    
    /**
     * Using the Current font and current art text find the width of the full image
     * @param textHeight
     * @param artText
     * @param fontName
     * @return
     */
    private static int findImageWidth(int textHeight, String artText, String fontName) {
        BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.getGraphics();
        g.setFont(new Font(fontName, Font.BOLD, textHeight));
        return g.getFontMetrics().stringWidth(artText);
    }
    
    /**
     * Find where the text baseline should be drawn so that the characters are within image
     * @param g
     * @param font
     * @return
     */
    private static int getBaselinePosition(Graphics g, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        return metrics.getAscent() - metrics.getDescent();
    }
}
