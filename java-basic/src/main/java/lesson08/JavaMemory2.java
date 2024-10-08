package lesson08;

public class JavaMemory2 {

  static void process(Person k) {
    System.out.printf("Processing main %s\n", k);
    k.age = 100;
    System.out.printf("Processing main %s\n", k);
  }

  public static void main(String[] args) {
    Person p = new Person("Jim", 33);
    System.out.printf("Processing main %s\n", p);
    process(p);
    System.out.printf("Processing main %s\n", p);
  }

}
