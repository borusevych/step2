package lesson07;

import lesson06.model.Person17;

public class DataComparing2 {

  public static void main(String[] args) {
    Person17 p1 = new Person17("Jim", 33);
    Person17 p2 = new Person17("Jim", 33);
    System.out.println(p1 == p2); // false
    System.out.println(p1.equals(p2)); // true
  }

}
