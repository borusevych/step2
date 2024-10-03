package lesson06;

import lesson06.model.Person;
import lesson06.model.User;

public class JavaObjects2 {

  static void registerUser(User u) {}
//  static void registerUser(Object u) {}

  public static void main(String[] args) {

    User user2 = new User("Margarita", 30, new String[]{"Java", "Scala"});
    System.out.println(user2);
    registerUser(user2);

    User user = new User("Margarita", 30);
    System.out.println(user);
    registerUser(user);

    User user3 = new User("Margarita", 30, "Java");
    System.out.println(user3);
    registerUser(user3);

    User user4 = new User("Margarita", 30, "Java", "Scala");
    System.out.println(user4);
    registerUser(user4);

    Person jim = new Person("Jim", 33);

  }

}
