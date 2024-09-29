package fr.fidtec.snippets;


import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import fr.fidtec.beans.User;

public class Reflection_Test {

	private static final String CLAZ_USER = "fr.fidtec.beans.User";
	
	// Usage classique d'un Bean java
	private User user = new User("COULON", "Fidele");
			
	@Test
	public void useCase1_Test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		
		// Création d'un Bean Java par reflexion (constructeur vide et setters)
		Object obj = Class.forName(CLAZ_USER).getDeclaredConstructor().newInstance();
			
		Method method1 = obj.getClass().getMethod("setNom", java.lang.String.class);
		method1.invoke(obj, "COULON");
		
		Method method2 = obj.getClass().getMethod("setPrenom", java.lang.String.class);
		method2.invoke(obj, "Fidele");
		

		System.out.println("User : " + user.toString());
		
		System.out.println("Obj : " + obj + " - " + obj.getClass());

		assertEquals(obj, user);
	}
		
	@Test
	public void useCase2_Test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		// Création d'un Bean Java par reflexion (constructeur avec paramètres)
		Object obj = Class.forName(CLAZ_USER)
				          .getDeclaredConstructor(java.lang.String.class, java.lang.String.class)
				          .newInstance("COULON", "Fidele");
				
		System.out.println("Obj : " + obj + " - " + obj.getClass());

		assertEquals(obj, user);
	}
	
	@Test(expected = ClassNotFoundException.class)
	public void useCase3_Test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		@SuppressWarnings("unused")
		Object obj3 = Class.forName(CLAZ_USER + "BAD")
				           .getDeclaredConstructor()
				           .newInstance();	

	}

}
