package fr.fidtec.snippets;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTrace_Test {
	
	private static final String NEW_LINE = System.getProperty("line.separator");
	
	private String getStackTraceWithException() {
	
		 StringBuilder result = new StringBuilder();
		 
		// add each element of the stack trace
	    for (StackTraceElement element : new Exception().getStackTrace()) { // new Throwable().getStackTrace()
	    result.append("Méthode " + element.getMethodName() + " - ");
	      result.append( element );
	      result.append( NEW_LINE );
	    }
	    
	    return result.toString();
	}
	

	private String getStackTraceWithThread() {
	
		 StringBuilder result = new StringBuilder();
	 
		 // add each element of the stack trace
		 for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
		     result.append("Méthode " + element.getMethodName() + " - "); 
			 result.append( element );
		     result.append( NEW_LINE );
		 }
		   
		 return result.toString();
	}
	
	@Test
	public void useCase1() {
		System.out.println("useCase1 : \n" + getStackTraceWithException());
		assertTrue(true);
	}
	
	@Test
	public void useCase2() {
		System.out.println("useCase2 : \n" + getStackTraceWithThread());
		assertTrue(true);
	}
}
