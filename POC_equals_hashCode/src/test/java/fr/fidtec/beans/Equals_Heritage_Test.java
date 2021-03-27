package fr.fidtec.beans;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Equals_Heritage_Test {
	
  @Test
  public void should_be_equals() throws Exception {
    final User user1 = new User();
    user1.setName("bali");

    final UserWithPassword user2 = new UserWithPassword();
    user2.setName("bali");
    user2.setPassword("balo");

    /* Reflexive */
    assertTrue(user1.equals(user1));
    assertTrue(user2.equals(user2));

    /* Symmetric */
    assertTrue(user1.equals(user2));
    assertTrue(user2.equals(user1)); // -> fails
  }

  @Test
  public void hashCode_should_be_the_same() throws Exception {
      final User user1 = new User();
      user1.setName("bali");

      final UserWithPassword user2 = new UserWithPassword();
      user2.setName("bali");
      user2.setPassword("balo");

      assertTrue(user1.equals(user2));

      /* contract with hashcode */
      assertTrue(user1.hashCode() == user2.hashCode()); // --> fails
  }
}
