package lesson14;

import java.util.List;
import java.util.function.Predicate;

public class Match {

  record Person(String name, int age) {}

  static boolean allGt18(List<Person> ps) {
    for (Person p : ps) {
      if (p.age >= 18) {}
      else return false;
    }
    return true;
  }

  static boolean noGt18(List<Person> ps) {
    for (Person p : ps) {
      if (p.age >= 18) return false;
    }
    return true;
  }

  static boolean atLestOneGt18(List<Person> ps) {
    for (Person p : ps) {
      if (p.age >= 18) return true;
    }
    return false;
  }

  static boolean predicatePerson(Person p) {
    return p.age >= 18;
  }

  public static void main(String[] args) {

    List<Person> people = List.of(
      new Person("Jim", 20),
      new Person("Tim", 22),
      new Person("Ben", 32)
    );

    // f: person -> boolean
    Predicate<Person> pp = p -> p.age >= 18;

    boolean all = people.stream()
      .allMatch(pp);

    boolean any = people.stream()
      .anyMatch(Match::predicatePerson);

    boolean any1 = people.stream()
      .anyMatch(p -> predicatePerson(p));

    boolean none = people.stream()
      .noneMatch(p -> p.age >= 18);

  }


}
