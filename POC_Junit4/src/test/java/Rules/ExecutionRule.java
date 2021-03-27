package Rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// Rules, which choose which statements to use to run tests.
public class ExecutionRule implements TestRule {

	  // description est la méthode de test lancée 
	  @Override
	  public Statement apply(Statement base, Description description) {
		System.out.println("Nom de la méthode du TU : " + description.getMethodName());
		System.out.println("Nom de la classe du TU : " + description.getClassName());
		System.out.println("Nom de complet (méthode+classe) du TU : " + description.getDisplayName());
	    return new ExecutionStatement(base);
	  }
	  
	  
	// statement = déclaration
	// Statements represent – simply spoken – your tests within the JUnit runtime and Statement#evaluate() executes them.
	// Wrapper de Statement which run tests.
	// A statement executes a test, and optionally does other work before and after executing the test.
	public class ExecutionStatement extends Statement {

		  private final Statement base;
		
		  public ExecutionStatement(Statement base) {
		    this.base = base;
		  }
		
		  // A typical evaluate() method acts as a wrapper around another statement.
		  // That is, it does something before the test, calls another statement’s evaluate() method to execute the test, then does something after the test.
		  @Override
		  public void evaluate() throws Throwable {
		    System.out.println("BeforeEach (Rule)");
		    
		    long startTime = System.currentTimeMillis();
		    
		    try {
		      base.evaluate();
			} finally {
		      System.out.println("AfterEach (Rule)");
		      long elapsedTime = System.currentTimeMillis() - startTime;
		      System.out.println("Temps d'exécution :" + elapsedTime + " ms");
		    }
		    
		  }
	}
		  
}
