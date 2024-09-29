package fr.fidtec.snippets;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.fidtec.exceptions.MyException;

public class Exception_Test {

	@Test
	public void useCase1() {
		try {
			throw new MyException("Coucou, j'ai planté !!!");			
		} catch (MyException e) {
			System.out.println("J'ai attrapé une " + e.getMessage() + "\n toString : " + e.toString());
		}
		
		assertTrue(true);
	}
	
	@Test
	public void useCase2() {	
		try {
			throw new MyException(new Exception());					
		} catch (MyException e) {
			System.out.println("J'ai attrapé une " + e.getMessage() + "\n toString : " + e.toString());
		}
		
		assertTrue(true);
	}
	
	@Test
	public void useCase3() {
		
		try {
			throw new MyException(new Exception());			
		} catch (MyException e) {
			System.out.println("J'ai encore attrapé une " + e.getMessage()+ "\n toString : " + e.toString());
		} finally {
			System.out.println("Je suis en phase Finally.");
		}
		
		assertTrue(true);
	}
	
	@Test(expected = MyException.class)
	public void useCase4() throws MyException {
		try {
			throw new MyException(new Exception());	// si pas de catch rend obligatoire throws MyException dans la méthode		
		} finally {
			System.out.println("Je suis en phase Finally.");
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void useCase5() {
		try {
			throw new RuntimeException(new Exception()); // si pas de catch une RunTime n'oblige pas le throws dans la méthode		
		} finally {
			System.out.println("Je suis en phase Finally.");
		}
	}

}
