package fr.fidtec.asciiart;

import static org.junit.Assert.assertTrue;

import java.awt.Font;

import org.junit.Test;

public class DrawString_Test {

	@Test
	public void useCase1() {
		
		String moi = "Fidele";
		
		Settings settings = new Settings(new Font("SansSerif", Font.BOLD, 24), moi.length() * 30, 30); // 30 pixel width per character

		String result = DrawString.draw(moi, "2", settings, Boolean.FALSE);
		System.out.println("result : \n" + result);
		
		assertTrue(true);
	}
	
}
