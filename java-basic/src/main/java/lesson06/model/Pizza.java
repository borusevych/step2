package lesson06.model;

public class Pizza {

  String name;
  int size;

  //public Pizza() {}
  // constructor
  public Pizza(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public static Pizza of(String name, int size) {
    return new Pizza(name, size);
  }

  public static Pizza random() {
    throw new IllegalArgumentException();
  }

  @Override
  public String toString() {
    return "Pizza{name='%s', size=%d}".formatted(name, size);
  }

}
