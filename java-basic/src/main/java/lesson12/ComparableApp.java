package lesson12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableApp {

  record Pizza(int size, String name, double price) implements Comparable<Pizza> {
    @Override
    public int compareTo(Pizza that) {
      return this.size - that.size;
    }
  }

  public static void main(String[] args) {

    Pizza p1 = new Pizza(30, "A", 3.5);
    Pizza p2 = new Pizza(60, "A", 5.9);
    Pizza p3 = new Pizza(60, "B", 4.9);

    ArrayList<Pizza> pizzas = new ArrayList<>();
    pizzas.add(p1);
    pizzas.add(p2);
    pizzas.add(p3);


    Collections.sort(pizzas);

//    pizzas.sort(comparatorBySize);
    pizzas.forEach(System.out::println);

    System.out.println("-------");
//    pizzas.sort(comparatorByPrice);
    pizzas.forEach(System.out::println);

    System.out.println("-------");
//    pizzas.sort(comparatorBySizePrice);
    pizzas.forEach(System.out::println);
  }


}
