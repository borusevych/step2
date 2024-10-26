package lesson16;

import java.io.Serializable;

public class Pizza implements Serializable {
  String name;
  int size;

  public Pizza(String name, int size) {
    this.name = name;
    this.size = size;
  }

  public static Pizza fromString(String in) {
    String[] data = in.split("\\|");
    String name = data[0];
    int size = Integer.parseInt(data[1]);
    return new Pizza(name, size);
  }

  public String represent() {
    return String.format("%s|%d", name, size);
  }

  @Override
  public String toString() {
    return "Pizza{" +
      "name='" + name + '\'' +
      ", size=" + size +
      '}';
  }
}