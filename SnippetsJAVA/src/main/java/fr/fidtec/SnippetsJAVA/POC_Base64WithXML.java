package fr.fidtec.SnippetsJAVA;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class POC_Base64WithXML {

	public static void main(String[] args) throws DecoderException {
		String moi = "Fidele COULON";
		
		// String xmlFlux = "<PDF>526d6c6b5a57786c49454e505655785054673d3d</PDF>";
		byte[] xmlFlux = Hex.decodeHex("526d6c6b5a57786c49454e505655785054673d3d");
		
		byte[] encode = Base64.encodeBase64(moi.getBytes());
		
		for (int i=0; i < encode.length; i ++) {
			System.out.println(encode[i]);
		}
		
		System.out.println(Hex.encodeHexString(encode));
		
		byte[] decode = Base64.decodeBase64(encode);
		
		String decodeString = new String(decode);
		
		System.out.println("Resultat : " + decodeString);
		
		byte[] decodeXML = Base64.decodeBase64(xmlFlux);
		
		String decodeXMLString = new String(decodeXML);
		
		System.out.println("ResultatXML : " + decodeXMLString);
		
	}
}
