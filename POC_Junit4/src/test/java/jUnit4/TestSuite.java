package jUnit4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/* 
 
 junit.framework.Test package is the legacy namespace used with Junit v3 and older versions of Java that do not support annotations.

 org.junit.Test is the new namespace used by JUnit v4 which requires Java v1.5 or later for its annotations.
 
 The current distributions of JUnit 4 include a copy of the old namespace to allow migration; however you should avoid using JUnit3 for new tests.

 In JUnit 4 both packages are included in the library for migrations purposes but you should use org.junit.Test for new code and you do not need to extend TestCase.

 Les nouveautés de JUnit4 (et plus particulièrement la version 4.5) apporte par rapport à JUnit3 :

    les annotations pour les tests
    les nouvelles assertions
    les suppositions
    les tests paramétrés
    les annotations pour les suites de tests
    
    les méthodes ne doivent plus commencer par test
    
*/
    
@RunWith(Suite.class)
@SuiteClasses({
	TU3Test.class,
	TU4Test.class,
})public class TestSuite
{
 /* empty class */
}