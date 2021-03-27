package fr.fidtec.beans;

public class UserWithHashCode extends User {
  @Override
  public int hashCode() {
      return getName() == null? 0 : getName().length(); // Ugly but correct!
  }
}
