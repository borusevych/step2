package lesson11;

import java.util.HashSet;

public class Collections7 {

  record Pizza17(String name) {
  }

  public static void main(String[] args) {
    {
      HashSet<Pizza> xs = new HashSet<>();

      Pizza p1 = new Pizza("Margarita", 30);
      Pizza p2 = new Pizza("Margarita", 30);
      Pizza p3 = new Pizza("Margarita", 30);
      xs.add(p1);
      xs.add(p2);
      xs.add(p3);

      System.out.println(xs.size());
      System.out.println("---------");
    }

    {
      HashSet<Pizza> xs = new HashSet<>();
      Pizza p4 = new Pizza("Margarita", 60);
      Pizza p5 = new Pizza("Margarita", 45);
      Pizza p6 = new Pizza("Margarita", 30);
      xs.add(p4);
      xs.add(p5);
      xs.add(p6);

      System.out.println(xs.size());
      System.out.println("---------");
    }
  }
}
