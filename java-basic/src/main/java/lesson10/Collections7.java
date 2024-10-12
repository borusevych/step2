package lesson10;

import lesson07.Pizza;

import java.util.HashSet;

public class Collections7 {

  record Pizza17(String name){}

  public static void main(String[] args) {
    {
      HashSet<Pizza> xs = new HashSet<>();

      xs.add(new Pizza("Margarita"));
      xs.add(new Pizza("Margarita"));

      System.out.println(xs.size()); // 2 - ?
    }

    {
      HashSet<Pizza17> xs = new HashSet<>();

      xs.add(new Pizza17("Margarita"));
      xs.add(new Pizza17("Margarita"));

      System.out.println(xs.size()); // 1 - !!!
    }
  }
}
