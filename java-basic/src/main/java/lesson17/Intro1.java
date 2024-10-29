package lesson17;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class Intro1 {

  public static void loadAll(DAO<Pizza> po) throws IOException, ClassNotFoundException {
    po.loadAll()
      .forEach(System.out::println);
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    //DAO<Pizza> po = new PizzaHashMapDAO();
    DAO<Pizza> po = new PizzaTxtFileDAO("pizza.txt");
    DAO<Student> so = new StudentBinFileDAO("student.bin");

    Pizza p1 = new Pizza(1, "M1", 30);
    Pizza p2 = new Pizza(2, "M2", 35);
    Pizza p3 = new Pizza(3, "M3", 60);

    Student s1 = new Student(11,"Jim", 33);
    Student s2 = new Student(12, "Jack", 33);

    po.save(List.of(p1, p2, p3));
    so.save(List.of(s1, s2));

    ///
    ///
    ///
    ///

    po.loadAll()
      .forEach(System.out::println);

    Optional<Pizza> p1L = po.load(1L);
    Optional<Pizza> p9L = po.load(9L);
    System.out.println(p1L); // Optional[Pizza{id=1, name='M1', size=30}]
    System.out.println(p9L); // Optional.empty


    so.loadAll()
      .forEach(System.out::println);
  }

}
