package lesson07;

public class InstanceOfExample {

  public static void main(String[] args) {
    Object s = "abc";
    System.out.println(s instanceof String); // true
    System.out.println(s instanceof Object); // true
    System.out.println(s instanceof Pizza); // false

    System.out.println();

    Object p = new Pizza("Margarita");
    System.out.println(p instanceof Pizza); // true
    System.out.println(p instanceof Object); // true
    System.out.println(p instanceof String); // false
  }

}
