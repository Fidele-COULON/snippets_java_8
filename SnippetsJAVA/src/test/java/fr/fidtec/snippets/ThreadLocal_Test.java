package fr.fidtec.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ThreadLocal_Test {

	public static final ThreadLocal<String> currentThreadLocal = new ThreadLocal<String>();
	 
	@Test
	public void useCase1() {
		
		String currentUser = currentThreadLocal.get();
		System.out.println("Je suis " + currentUser + ".");
		assertNull(currentUser);
		
		currentThreadLocal.set("Fidele");
		currentUser = currentThreadLocal.get();		
		System.out.println("Je suis " + currentUser + ".");
		assertEquals("Fidele", currentUser);
	}

}
