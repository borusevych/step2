package lesson15;

import java.util.Optional;

public class Person {
  private String name;
  private int age;
  Optional<String> skill;

  public Person(String name, int age, Optional<String> skill) {
    this.name = name;
    this.age = age;
    this.skill = skill;
  }

  public static Person of(String name, int age, String skill) {
    return new Person(name, age, Optional.of(skill));
  }

  public static Person noSkill(String name, int age) {
    return new Person(name, age, Optional.empty());
  }

  public static void main(String[] args) {
    new Person("jim", 33, Optional.of("java"));
    new Person("jim", 33, Optional.empty());
    Person.of("jim", 33, "java");
    Person.noSkill("jim", 33);
  }


}
