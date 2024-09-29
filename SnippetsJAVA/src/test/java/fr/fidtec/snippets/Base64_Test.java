package fr.fidtec.snippets;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class Base64_Test {

	private static final String MOI = "Fidele COULON";
	
	@Test
	public void EncodeApacheBase64_Test() {
		
		byte[] encode = org.apache.commons.codec.binary.Base64.encodeBase64(MOI.getBytes());
		
		Stream.of(encode).forEach(System.out::println);
		
		byte[] decode = org.apache.commons.codec.binary.Base64.decodeBase64(encode);
		
		String decodeString = new String(decode);
		
		System.out.println("Resultat : " + decodeString);
		
		assertEquals(MOI, decodeString);
		
	}

	@Test
	public void EncodeJavaBase64_Test() {
		
		byte[] encode = java.util.Base64.getEncoder().encode(MOI.getBytes());
		
		Stream.of(encode).forEach(System.out::println);
		
		byte[] decode = java.util.Base64.getDecoder().decode(encode);
		
		String decodeString = new String(decode);
		
		System.out.println("Resultat : " + decodeString);
		
		assertEquals(MOI, decodeString);
		
	}

}
