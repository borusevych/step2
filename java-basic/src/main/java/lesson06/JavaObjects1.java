package lesson06;

public class JavaObjects1 {

  static void deliverPizza(int size, String name) {}

  static void registerUser(String name, int age) {}

  public static void main(String[] args) {

    int size = 30;
    String name = "Margarita";

    deliverPizza(size, name);
    registerUser(name, size);
  }

}
