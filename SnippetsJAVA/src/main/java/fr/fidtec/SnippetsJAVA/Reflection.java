package fr.fidtec.SnippetsJAVA;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		// Usage classique d'un Bean java
		User user = new User("COULON", "Fidele");
		System.out.println("User " + user.toString());
		
		// Création d'un Bean Java par reflexion (constructeur vide et setters)
		Object obj = Class.forName("fr.fidtec.SnippetsJAVA.User").getDeclaredConstructor().newInstance();
		
		Method method1 = obj.getClass().getMethod("setNom", java.lang.String.class);
		method1.invoke(obj, "COULON2");
		
		Method method2 = obj.getClass().getMethod("setPrenom", java.lang.String.class);
		method2.invoke(obj, "Fidele2");
		
		System.out.println(obj + " - " + obj.getClass());
		
		// Création d'un Bean Java par reflexion (constructeur avec paramètres)
		Object obj2 = Class.forName("fr.fidtec.SnippetsJAVA.User")
				           .getDeclaredConstructor(java.lang.String.class, java.lang.String.class)
				           .newInstance("COULON3", "Fidele3");
				
		System.out.println(obj2 + " - " + obj2.getClass());
				
		// java.lang.ClassNotFoundException
		@SuppressWarnings("unused")
		Object obj3 = Class.forName("fr.fidtec.SnippetsJAVA.User2").getDeclaredConstructor().newInstance();	
	}

}
