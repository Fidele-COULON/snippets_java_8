package fr.fidtec.beans;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class HashSet_Test {
	
	// Ce qu'il se produit ici est que les Hash(Map|Set) classent les objets dans un histogramme basé sur le hashCode.
	// A l'instar d'equals, le hashCode par défaut de Hotspot convertit l'adresse en entier et donc retourne des valeurs différentes pour des objets différents.
	//
	// Les méthodes des hash collections utilisent la valeur du hashCode pour localiser un objet dans l'histogramme et si celui-ci ne contient pas cet entier,
	// alors il est considéré que l'objet ne figure pas dans la collection.
	//
	// Puisque deux objets distincts mais sémantiquement égaux ont des hashCode différents, alors ils sont rangés dans des buckets différents impliquant le
	// stockage de doublons, ce qui est en rupture avec le contrat de base du Set.
	@Test
    public void testHashSet_With_User() throws Exception {
        final User user1 = new User();
        user1.setName("bali");

        final User user2 = new User();
        user2.setName("bali");

        final Set<User> users = new HashSet<>();
        users.add(user1);

        assertTrue(users.iterator().next().equals(user2)); // OK avec le equals
        assertFalse(users.contains(user2)); // --> fails car sans HashCode!
    }

	@Test
    public void testHashSet_With_UserWithHashCode() throws Exception {
        final User user1 = new UserWithHashCode();
        user1.setName("bali");

        final User user2 = new UserWithHashCode();
        user2.setName("bali");

        final Set<User> users = new HashSet<>();
        users.add(user1);

        assertTrue(users.iterator().next().equals(user2)); // OK avec le equals
        assertTrue(users.contains(user2)); // OK avec le HashCode
    }

    @Test
    public void testHashMap_With_User() throws Exception {
        final User user1 = new User();
        user1.setName("bali");

        final User user2 = new User();
        user2.setName("bali");

        final Map<User, Integer> map = new HashMap<>();
        map.put(user1, 2);

        assertTrue(map.size() ==1);
        assertTrue(map.keySet().iterator().next().equals(user2));
        assertTrue(map.values().iterator().next().equals(2));
        assertFalse(map.containsKey(user2)); // --> fails!
    }

    @Test
    public void testHashMap_With_UserWithHashCode() throws Exception {
        final User user1 = new UserWithHashCode();
        user1.setName("bali");

        final User user2 = new UserWithHashCode();
        user2.setName("bali");

        final Map<User, Integer> map = new HashMap<>();
        map.put(user1, 2);

        assertTrue(map.size() ==1);
        assertTrue(map.keySet().iterator().next().equals(user2));
        assertTrue(map.values().iterator().next().equals(2));
        assertTrue(map.containsKey(user2));
    }
    
    @Test
    public void should_not_contain_doubles_With_User() throws Exception {
        final User user1 = new User();
        user1.setName("bali");

        final User user2 = new User();
        user2.setName("bali");

        final Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);

        assertTrue(user1.equals(user2));
        assertFalse(users.size() == 1); // -> fails
    }
    
    @Test
    public void should_not_contain_doubles_With_UserWithHashCode() throws Exception {
        final User user1 = new UserWithHashCode();
        user1.setName("bali");

        final User user2 = new UserWithHashCode();
        user2.setName("bali");

        final Set<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);

        assertTrue(user1.equals(user2));
        assertTrue(users.size() == 1); 
    }
}
