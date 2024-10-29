package lesson17;

import java.io.Serializable;

public class Student implements Serializable, HasId {
  long id;
  String name;
  int age;

  public Student(long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public static Student fromString(String in) {
    String[] data = in.split("\\|");
    long id = Long.parseLong(data[0]);
    String name = data[1];
    int size = Integer.parseInt(data[2]);
    return new Student(id, name, size);
  }

  public String represent() {
    return String.format("%d|%s|%d", id, name, age);
  }

  @Override
  public String toString() {
    return "Student{id=%d, name='%s', age=%d}".formatted(id, name, age);
  }

  @Override
  public long id() {
    return id;
  }
}