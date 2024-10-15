package lesson11;

import java.util.Objects;

public class Pizza {
  String name;
  int size;

  public Pizza(String name, int size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    System.out.println("calculating equals...");
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pizza pizza = (Pizza) o;
    return size == pizza.size && Objects.equals(name, pizza.name);
  }

  @Override
  public int hashCode() {
    System.out.println("calculating hashcode...");
//    return 1;
    return Objects.hash(name, size);
  }
}
