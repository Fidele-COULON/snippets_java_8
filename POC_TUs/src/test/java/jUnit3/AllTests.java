package jUnit3;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	
	public static Test suite() {

		TestSuite suite = new TestSuite("Suite de tests"); 	
		
		//$JUnit-BEGIN$
		suite.addTest(new TestSuite(TU1Test.class));
		suite.addTest(new TestSuite(TU2Test.class));
		//$JUnit-END$
		
		return suite;

	}
}
