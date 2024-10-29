package lesson17;

import java.io.Serializable;

public class Pizza implements Serializable, HasId {
  long id;
  String name;
  int size;

  public Pizza(long id, String name, int size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  @Override
  public long id() {
    return id;
  }

  public static Pizza fromString(String in) {
    String[] data = in.split("\\|");
    long id = Long.parseLong(data[0]);
    String name = data[1];
    int size = Integer.parseInt(data[2]);
    return new Pizza(id, name, size);
  }

  public String represent() {
    return String.format("%d|%s|%d", id, name, size);
  }

  @Override
  public String toString() {
    return "Pizza{id=%d, name='%s', size=%d}".formatted(id, name, size);
  }

}