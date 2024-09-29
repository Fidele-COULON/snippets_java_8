package fr.fidtec.asciiart;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class DrawString {

	private DrawString() {}
	
	private static final int ZERO_IMAGE = -16777216; // The zero equivalent of the integer mode is -16777216.
	
	private static final String ESPACE = " ";
	
	public static String draw(String text, String artChar, Settings settings, Boolean inverseImage) {
		
		BufferedImage image = new BufferedImage(settings.getWidth(), settings.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = image.getGraphics();	
		graphics.setFont(settings.getFont());

        Graphics2D graphics2D = (Graphics2D) graphics;
        
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        graphics2D.drawString(text, 2, 20); // String, x ,y
        
        StringBuilder result = new StringBuilder();
        
		for (int y = 0; y < settings.getHeight(); y++) {
			
		    StringBuilder line = new StringBuilder();

		    for (int x = 0; x < settings.getWidth(); x++) {
		    	
		    	// The fundamental idea is to replace the values assigned to non-zero indices of the image matrix with the desired artistic character.

		         // stringBuilder.append(artChar); // Que des artChar
		    	if (Boolean.TRUE.equals(inverseImage)) {
		    		line.append(image.getRGB(x, y) == ZERO_IMAGE ? artChar : ESPACE); // en blanc sur fond de artChar
		    	} else {
		    		line.append(image.getRGB(x, y) == ZERO_IMAGE ? ESPACE : artChar); // en noir sur fond blanc
		    	}
		    }

		    if (line.toString().trim().isEmpty()) {
		        continue;
		    }

		    result.append(line + "\n");
		}
		
		return result.toString();
	}
}
