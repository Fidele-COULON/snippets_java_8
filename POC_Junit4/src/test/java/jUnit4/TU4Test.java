package jUnit4;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class TU4Test {
	
	// Ces annotations permettent d'indiquer une méthode qui sera exécutée avant l'ensemble des tests d'un cas de tests et une méthode qui sera exécutée après l'ensemble des tests d'un cas de tests. 
    @BeforeClass
    public static void avantTests() {
        System.out.println("------------------------");
        System.out.println("Avant tous les tests");
        System.out.println("------------------------");
    }
    
    @AfterClass
    public static void apresTests() {
        System.out.println("------------------------");
        System.out.println("Après tous les tests");
        System.out.println("------------------------");
    }
    
	// Ces annotations permettent d'indiquer une méthode qui sera exécutée avant chaque test et une méthode qui sera exécutée après chaque test. 
    @Before
    public void avantTest() {
        System.out.println("------------------------");
        System.out.println("Avant chaque test");
    }
    
    @After
    public void apresTest() {
        System.out.println("Après chaque test");
        System.out.println("------------------------");
    }
    
    // TU réalisés
	@Test
	public void Test1() {
		assertTrue(false);
	}
	
	@Test
	public void Test2() {
		assertTrue(true);
	}

	@Test(expected=ArithmeticException.class)
	public void Test3() {
		@SuppressWarnings("unused")
		int foo= 10 /0 ;
	}
	
	@Test(expected=ArithmeticException.class)
	public void Test4() {
		@SuppressWarnings("unused")
		int foo= 10 /5 ;
	}
	
	@Test(timeout=1000)
    public void dureeRespectee() {
        
    }

    @Test(timeout=1000)
    public void dureeNonRespectee() throws InterruptedException {
        Thread.sleep(10000);
    }
}
