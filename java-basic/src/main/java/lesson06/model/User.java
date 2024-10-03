package lesson06.model;

import lesson06.Utils;

import java.util.Arrays;

public class User {

  String name;
  int age;
  String[] skills;

  public User(String name, int age, String[] skills) {
    this.name = name;
    this.age = age;
    this.skills = skills;
  }

  @Override
  public String toString() {
    return "User{name='%s', age=%d, skills=%s}"
      .formatted(name, age, Arrays.toString(skills));
  }

  public User(String name, int age) {
    this(name, age, new String[0]);
  }

  public User(String name, int age, String skill, String... skills) {
    this(name, age, Utils.combine(skill, skills));
  }

}
