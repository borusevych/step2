package lesson12;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorApp {

  record Pizza(int size, String name, double price) {
  }

  public static void main(String[] args) {

    Pizza p1 = new Pizza(30, "A", 3.5);
    Pizza p2 = new Pizza(60, "A", 5.9);
    Pizza p3 = new Pizza(60, "B", 4.9);

    Comparator<Pizza> comparatorBySize = new Comparator<>() {
      @Override
      public int compare(Pizza o1, Pizza o2) {
        return o1.size - o2.size;
      }
    };

    Comparator<Pizza> comparatorByPrice = new Comparator<>() {
      @Override
      public int compare(Pizza o1, Pizza o2) {
        return (int) (o1.price - o2.price);
      }
    };

    Comparator<Pizza> comparatorBySizePrice = new Comparator<>() {
      @Override
      public int compare(Pizza o1, Pizza o2) {
        int s = o1.size - o2.size;
        if (s != 0) return s;
        return (int) (o1.price - o2.price);
      }
    };

    ArrayList<Pizza> pizzas = new ArrayList<>();
    pizzas.add(p1);
    pizzas.add(p2);
    pizzas.add(p3);

    pizzas.sort(comparatorBySize);
    pizzas.forEach(System.out::println);

    System.out.println("-------");
    pizzas.sort(comparatorByPrice);
    pizzas.forEach(System.out::println);

    System.out.println("-------");
    pizzas.sort(comparatorBySizePrice);
    pizzas.forEach(System.out::println);

  }


}
