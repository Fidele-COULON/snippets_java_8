package fr.fidtec.SnippetsJAVA;

import java.util.HashMap;
import java.util.Map;

public class WorkWithBoolean {

	private static Map<String,Object> map = new HashMap<String,Object> ();
	
	public static void main(String[] args) {
		
		System.out.println("1a :" + Boolean.TRUE); // true 		
		System.out.println("1b :" + Boolean.TRUE.toString()); // true
		
		System.out.println("2a :" + Boolean.valueOf((String) map.get("foo"))); // false
		
		// System.out.println("2b :" + Boolean.valueOf(map.get("foo").toString())); // java.lang.NullPointerException

		map.put("foo", "true");
				
		System.out.println("3a :" + Boolean.valueOf((String) map.get("foo"))); // true
		System.out.println("3b :" + Boolean.valueOf(map.get("foo").toString())); // true
		
		map.put("foo", Boolean.FALSE);

		// System.out.println("4a :" + Boolean.valueOf((String) map.get("foo"))); // Java.lang.Boolean cannot be cast to java.lang.String
		System.out.println("4b :" + Boolean.valueOf(map.get("foo").toString())); // false
	}

}
