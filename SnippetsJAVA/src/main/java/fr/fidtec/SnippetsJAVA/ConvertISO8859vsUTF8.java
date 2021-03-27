package fr.fidtec.SnippetsJAVA;

import java.io.UnsupportedEncodingException;

public class ConvertISO8859vsUTF8 {
	
	final static String sBat = "Bât";
	
	public static void main(String[] args) {	
		
		System.out.println("Encodage : "+System.getProperty("file.encoding")); // Encodage : UTF-8
		
		try {
			String s = new String(sBat.getBytes("UTF-8"),"ISO-8859-1");
			
		    System.out.println("Original : " + s);  // Original : BÃ¢t
		    
		    System.out.println("UTF-8 vers ISO-8859-1 : " + new String(s.getBytes("UTF-8"),"ISO-8859-1"));     // UTF-8 vers ISO-8859-1 : BÃÂ¢t
		    System.out.println("UTF-8 vers ISO-8859-15 : " + new String(s.getBytes("UTF-8"),"ISO-8859-15"));   // UTF-8 vers ISO-8859-15 : BÃÂ¢t
		    System.out.println("UTF-8 vers windows-1252 : " + new String(s.getBytes("UTF-8"),"windows-1252")); // UTF-8 vers windows-1252 : BÃƒÂ¢t
		    System.out.println("UTF-8 vers cp1252 : " + new String(s.getBytes("UTF-8"),"cp1252"));             // UTF-8 vers cp1252 : BÃƒÂ¢t
		    System.out.println("ISO-8859-1 vers UTF-8 : " + new String(s.getBytes("ISO-8859-1"),"UTF-8"));     // ISO-8859-1 vers UTF-8 : Bât
		    
		} catch(UnsupportedEncodingException uee) {
		    uee.printStackTrace();
		}
		
	}
}
