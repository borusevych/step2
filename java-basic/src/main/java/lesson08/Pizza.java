package lesson08;

public class Pizza {
  String name;
  static int size;
  final static double discount = 0.2;
  final static String message = "size must be at least 10";

  public Pizza(String name, int size) {
    this.name = name;
    if (size < 10)
      throw new IllegalArgumentException(message);
    this.size = size;
  }

  public Pizza(String name) {
    this.name = name;
  }

  public int getPrice() {
    return (int) (size * 5 * discount);
  }


  @Override
  public String toString() {
    return "Pizza{name='%s', size=%d}".formatted(name, size);
  }
}
