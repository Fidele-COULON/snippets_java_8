package Rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PreRequisRule implements TestRule {

	  // description est la méthode de test lancée 
	  @Override
	  public Statement apply(Statement base, Description description) {
		System.out.println("Exécution des Pré-requis !!!!");
	    return base;
	  }   
}
