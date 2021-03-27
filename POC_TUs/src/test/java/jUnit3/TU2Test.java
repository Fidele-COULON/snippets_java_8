package jUnit3;

import junit.framework.TestCase;

public class TU2Test  extends TestCase {
	
	public void test1() {
		System.out.println("Test1");
		assertTrue(false);
	}
	
	public void test2() {
		System.out.println("Test2");
		assertTrue(true);
	}
	
	public void setUp() {
		System.out.println("A chaque début de Test");	
	}
	
	public void tearDown() {
		System.out.println("A chaque fin  de Test");	
	}
	
}
