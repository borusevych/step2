package lesson07;

import lesson06.model.Person;

public class DataComparing2 {

  public static void main(String[] args) {
    Person p1 = new Person("Jim", 33);
    Person p2 = new Person("Jim", 33);
    System.out.println(p1 == p2); // false
    System.out.println(p1.equals(p2)); // true
  }

}
