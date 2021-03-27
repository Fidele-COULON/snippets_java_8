package fr.fidtec.beans;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Equals_Test {
	
	// Utilisé entre deux objets, ce sont les adresses des références qui sont comparées, ce qui implique que l'utilisation de == sur deux instances distinctes
	// sémantiquement équivalentes retournera false
	@Test
    public void should_not_be_equals_equals() throws Exception {
        final User user1 = new User();

        final String userName = "user";
        user1.setName(userName);
        
        final User user2 = new User();
        user2.setName(userName);

        assertFalse(user1 == user2);
    }
	
	// Si le choix de ne pas redéfinir equals est retenu, l'implémentation d'Object ne fait que comparer les adresses, soit le même comportement que ==
	@Test
    public void should_be_equals() throws Exception {
        final User user1 = new User();
        user1.setName("bali");

        final User user2 = new User();
        user2.setName("bali");

        final User user3 = new User();
        user3.setName("bali");

        /* Reflexive */
        assertTrue(user1.equals(user1));
        assertTrue(user2.equals(user2));
        assertTrue(user3.equals(user3));

        /* Symmetric */
        assertTrue(user1.equals(user2));
        assertTrue(user2.equals(user1));

        /* Transitive */
        assertTrue(user1.equals(user2)); //rappel
        assertTrue(user2.equals(user3));
        assertTrue(user1.equals(user3));

        assertFalse(user1.equals(null));
        assertFalse(user2.equals(null));
        assertFalse(user3.equals(null));
    }
}
