package fr.fidtec.demos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MultipleSingletons_Test {

	@Test
	public void DoubleCheckingLockingSingleton_Test() {
		System.out.println("Demarrage du programme :  le singleton n'est pas charge ...");
		
        System.out.println("Appel au singleton ...");
        DoubleCheckingLockingSingleton singleton = DoubleCheckingLockingSingleton.getInstance();
        
        System.out.println("Voici le message du singleton : " + singleton.getMessage() + " de la classe " + singleton.getClass());
        
        assertNotNull(singleton);
	}
	
	@Test
	public void LazySingleton_Creation_Test() {
		System.out.println("Demarrage du programme :  le singleton n'est pas charge ...");
		
        System.out.println("Appel au singleton ...");
        LazySingleton singleton = LazySingleton.getInstance();
        
        System.out.println("Voici le message du singleton : " + singleton.getMessage() + " de la classe " + singleton.getClass());
        
        assertNotNull(singleton);
	}
	
	@Test
	public void LazySingletonWithEnum_Direct_Access_Test() {
		System.out.println("Demarrage du programme :  le singleton n'est pas charge ...");
		
        System.out.println("Appel au singleton ...");
        LazySingletonWithEnum singleton = LazySingletonWithEnum.INSTANCE;
        
        System.out.println("Voici le message du singleton : " + singleton.getMessage() + " de la classe " + singleton.getClass());
        
        assertNotNull(singleton);
	}
	
	@Test
	public void LazySingletonWithEnum_With_GetInstance_Call_Test() {
		System.out.println("Demarrage du programme :  le singleton n'est pas charge ...");
		
        System.out.println("Appel au singleton ...");
        LazySingletonWithEnum singleton = LazySingletonWithEnum.getInstance();
        
        System.out.println("Voici le message du singleton : " + singleton.getMessage() + " de la classe " + singleton.getClass());
        
        assertNotNull(singleton);
	}
	
	
}
