package fr.fidtec.predicates;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

import fr.fidtec.lambdas.IConcatStrings;
import fr.fidtec.lambdas.INumToMonth;
import fr.fidtec.lambdas.IOperation;
import fr.fidtec.lambdas.ISalutation;

// https://www.geeksforgeeks.org/closures-in-java-with-examples/
// https://toungafranck.com/2017/10/17/les-closures-limitation-de-java-8/
public class Lambdas_Test {

	// Les expressions Lambda (ainsi que les classes anonymes) en Java ne peuvent accéder qu’aux variables finales (ou effectivement final) de la portée englobante.
	@Test
	public void runnableOldSchool_Test() { // NOSONAR
		int answer = 42;
		
		Thread t = new Thread(new Runnable() { // classes anonymes
			public void run() {
				System.out.println("OldSchool : The answer is : " + answer);
			}
		});	
		
		t.start();
	}
	
	@Test
	public void runnableNewSchool_Test() { // NOSONAR
		int answer = 42;
		
		Thread t = new Thread(
				() -> System.out.println("NewSchool : The answer is : " + answer) // expression lambda Java 8
		);	
		
		t.start();
	}
	
	
	@Test
	public void ISalutation_Test() {  // NOSONAR
		
		// Lambda Expression
        ISalutation obj = () ->
        {
            return "Hello, Fidele !";
        };
        
        System.out.println(obj.sayHello());
        
	}
	
	@Test
	public void IConcatStrings_Test() {
		IConcatStrings s = (s1, s2) -> s1 + s2;
		
		System.out.println(s.concat("Hello, ", "Fidele !"));
		
		assertEquals("Hello, Fidele !", s.concat("Hello, ", "Fidele !"));
	}
	
	// ==============================================================================================================================
	// https://medium.com/@rmanavalan/5-ways-to-implement-closures-in-java-8-590790659ac5
	// ==============================================================================================================================
	
	/* = 1 with InnerClass =
	  Highly debatable, but obj can be considered a closure because it bundles the convert function
	  and the months data (private to obj) without deliberately defining months within the convert function. 
	 */
	@Test
	public void INumToMonth_InnerClass_Test() {
		 INumToMonth obj = new INumToMonth() {
	            String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	 
	            public String convertToMonth(int n) {
	                return (n > 0 && n <= months.length) ? months[n-1] : null;
	            };
	     };
	     
	     System.out.println(obj.convertToMonth(8));
	     
	     assertEquals("Aug", obj.convertToMonth(8));
	}
	
	//= 2 with Lambda =
	// differs in the way the functional interface is implemented : Lambda expression instead of inner class.
	@Test
	public void INumToMonth_Lambda_Test() {
		 INumToMonth obj =
				 n -> { // lambda
	            		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	            		return (n > 0 && n <= months.length) ? months[n-1] : null;
	               	  };
	     
	     System.out.println(obj.convertToMonth(8));
	     
	     assertEquals("Aug", obj.convertToMonth(8));
	}
	
	//= 3 with Function =
	// This is similar to Example 2, except that the use of predefined “Function” interface avoids the need to write a custom interface.
	// It is in fact, an anti-pattern to write custom functional interfaces for those that Java has predefined.
	@Test
	public void INumToMonth_Function_Test() {
		 Function<Integer, String> fct =
				 n -> { // lambda
	            		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	            		return (n > 0 && n <= months.length) ? months[n-1] : null;
	               	  };
	     
	     System.out.println(fct.apply(8));
	     
	     assertEquals("Aug", fct.apply(8));
	}
	
	//= 4 with Function, Lambda and InnerClass =
	private Function<Integer, String> obj() {
		 String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		 
		 // inner function that encloses/remembers months
		 return n -> (n > 0 && n <= months.length) ? months[n-1] : null;
	}
		
	@Test
	public void INumToMonth_Function_Lambda_InnerClass_Test() {
	     
	     System.out.println(obj().apply(8));
	     
	     assertEquals("Aug", obj().apply(8));
	} 
	
	//= 5 Using predefined Functional Interface, Lambda expression & inner function having access to parent scope which is nothing but state passed by the client 
	private Function<Integer, String> getWeekDay(String [] weeks) {
		 return n -> (n > 0 && n <= weeks.length) ? weeks[n-1] : null;
	}
	
	@Test
	public void getWeekDay_Test() {
		
		Function<Integer, String> getIndianTextofWeekDay = getWeekDay(new String[] {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim"});
		Function<Integer, String> getArabTextofWeekDay = getWeekDay(new String[] {"Ven", "Sam", "Dim", "Lun", "Mar", "Mer", "Jeu"});		
		
		System.out.println(getIndianTextofWeekDay.apply(5));
		assertEquals("Ven", getIndianTextofWeekDay.apply(5));
		
		System.out.println(getArabTextofWeekDay.apply(5));
		assertEquals("Mar", getArabTextofWeekDay.apply(5));
	}
	 
	
	// ==============================================================================================================================
	private static void doSomeCalcul(int i, IOperation op) {
	       op.operate(i);
	}
	 
	@Test
	public void IOperation_Test() { // NOSONAR
		int a = 12;
	    int b = 88;
	 
	   // implementation of closure in lambda expression
	    doSomeCalcul(a, new IOperation(){    
			        		public void operate(int n) {
			        			System.out.println("Result is: " + (n + b));
			        		}
	    				});
	}
}
