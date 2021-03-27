package Rules;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class RulesTU_POC_Test {

  // @Rule annotations, which tell JUnit which rules to apply to your test class (must be public, not static and a subtype of TestRule).
  @Rule
  public ExecutionRule executionRule = new ExecutionRule();
	
  @Rule
  public PreRequisRule preRequisRule = new PreRequisRule();
  
  // Lancé en tout 1er (avant tous les autres)
  @BeforeClass
  public static void setup() {
	  System.out.println("BeforeClass");
  }
  
  // Lancé avant Rule
  @Before
  public void init() {
      System.out.println("Before");
  }

  // Lancé après Rule
  @After
  public void finalize() {
	  System.out.println("After");
  }
  
  // Lancé en tout dernier (avant toutes les autres)
  @AfterClass
  public static void tearDown() {
	  System.out.println("AfterClass");
  }
  
	/*
	 * Flow. To execute each test method, JUnit conceptually follows this flow:
	 * 
	 * 1. Create a default statement to run the test.
	 * 
	 * 2. Find all of test class’s rules by looking for public member fields annotated with @Rule.
	 * 
	 * 3. Call each rule’s apply() method, telling it which test class and method are to be run, and what statement JUnit has gathered so far.
	 *    apply() decides how to run the test, selects or creates the appropriate statement to run the test, and returns that statement to JUnit.
	 *    
	 *    JUNit then passes this statement to the next rule’s apply() method, and so on.
	 *    
	 * 4. Run the test by calling the evaluate() method of the statement returned by the last rule.
	 * 
	 */
  @Test
  public void Test1() throws InterruptedException {
    Thread.sleep(1000); // en ms
    System.out.println("Execute Test1");
    Thread.sleep(1000); // en ms
  }
  
  @Test
  public void Test2() {
    System.out.println("Execute Test2");
  }
  
}
