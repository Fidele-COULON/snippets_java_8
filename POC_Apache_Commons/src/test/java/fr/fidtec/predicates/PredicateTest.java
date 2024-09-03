package fr.fidtec.predicates;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.*;
import org.junit.Test;

public class PredicateTest {

	/* https://www.oreilly.com/library/view/jakarta-commons-cookbook/059600706X/ch04s08.html
	  
	 perform logic that is predicated on a certain condition being satisfied, 
	 and you want to encapsulate this condition in an object
	 
	 Use a Predicate to evaluate a criteria or a condition.
	 
	 A Predicate is an object that evaluates another object and returns true or false;
	 predicates are used throughout the Commons Collections packages for filtering, selecting
	 and validating the contents of collections.
	*/
	
	@Test
	public void PredicateSimple_Test() {
		
		String name = "Fidele";

		Predicate<String> isNameToto = new EqualPredicate<String>("Toto");
		Predicate<String> isNameFidele = new EqualPredicate<String>("Fidele");

		Predicate<Object> isInstanceOfString = new InstanceofPredicate(String.class);
		Predicate<Object> isInstanceOfDouble = new InstanceofPredicate(Double.class);

		// Testing all predicates for "Tim"
		System.out.println( "Is Name Toto : " + isNameToto.evaluate(name));
		assertFalse(isNameToto.evaluate(name));
		
		System.out.println( "Is Name Fidele : " + isNameFidele.evaluate(name));
		assertTrue(isNameFidele.evaluate(name));
		
		System.out.println( "Is this a String : " + isInstanceOfString.evaluate(name));
		assertTrue(isInstanceOfString.evaluate(name));
		
		System.out.println( "Is this a Double : " + isInstanceOfDouble.evaluate(name));
		assertFalse(isInstanceOfDouble.evaluate(name));
	}
	
	// https://commons.apache.org/dormant/commons-functor/examples.html
	@Test
	public void PredicateCustom_Test() {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

		Predicate<Integer> isEven = new Predicate<Integer>() {
		    public boolean evaluate(Integer obj) {
		        return obj % 2 == 0;
		    }
		};
		
		assertFalse(isEven.evaluate(numbers.get(0)));
		assertTrue(isEven.evaluate(numbers.get(1)));		
	}
}
