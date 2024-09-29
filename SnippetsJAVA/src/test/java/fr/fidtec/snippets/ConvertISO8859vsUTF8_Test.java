package fr.fidtec.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class ConvertISO8859vsUTF8_Test {
	
	private final static String BAT_ACCENT = "Bât";
	
	@Test
	public void convertBatTest() {	
		
		System.out.println("Encodage : " + System.getProperty("file.encoding")); // Encodage : UTF-8
		
		try {
			
			String s = new String(BAT_ACCENT.getBytes("UTF-8"),"ISO-8859-1");
			
		    System.out.println("String encodée UTF8 Originale : " + s);  // Original : BÃ¢t
		   
		    System.out.println("UTF-8 vers ISO-8859-1 : "   + new String(s.getBytes("UTF-8"),"ISO-8859-1"));     // UTF-8 vers ISO-8859-1 : BÃÂ¢t
		    assertNotEquals(BAT_ACCENT,  new String(s.getBytes("UTF-8"),"ISO-8859-1"));
		    		   
		    System.out.println("UTF-8 vers ISO-8859-15 : "  + new String(s.getBytes("UTF-8"),"ISO-8859-15"));    // UTF-8 vers ISO-8859-15 : BÃÂ¢t
		    assertNotEquals(BAT_ACCENT,  new String(s.getBytes("UTF-8"),"ISO-8859-15"));
		    		    
		    System.out.println("UTF-8 vers windows-1252 : " + new String(s.getBytes("UTF-8"),"windows-1252"));   // UTF-8 vers windows-1252 : BÃƒÂ¢t
		    assertNotEquals(BAT_ACCENT,  new String(s.getBytes("UTF-8"),"windows-1252"));
		    
		    System.out.println("UTF-8 vers cp1252 : "       + new String(s.getBytes("UTF-8"),"cp1252"));         // UTF-8 vers cp1252 : BÃƒÂ¢t
		    assertNotEquals(BAT_ACCENT,  new String(s.getBytes("UTF-8"),"cp1252"));
		    
		    System.out.println("ISO-8859-1 vers UTF-8 : "   + new String(s.getBytes("ISO-8859-1"),"UTF-8"));     // ISO-8859-1 vers UTF-8 : Bât
		    assertEquals(BAT_ACCENT,  new String(s.getBytes("ISO-8859-1"),"UTF-8"));
		   		    
		} catch(UnsupportedEncodingException uee) {
		    uee.printStackTrace();
		}
		
	}
}
