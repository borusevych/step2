package lesson09;

public class Oop1 {

  static class Person {}
  static class Cat {}

  public static void main(String[] args) {
    Person person = new Person();
    Cat cat = new Cat();
    System.out.println(person instanceof Person);
    System.out.println(person instanceof Object);
    System.out.println(cat instanceof Object);
  }

}
