package lesson06;

import lesson06.model.Pizza;

import java.util.Arrays;

public class JavaObjects3 {

  static void deliverPizza(Pizza p) {}

  public static void main(String[] args) {
    System.out.println(args.length);
    System.out.println(Arrays.toString(args));

    Pizza pizza = new Pizza("Margarita", 30);

    deliverPizza(pizza);

    System.out.println(pizza); // lesson06.model.Pizza@30f39991
    // Pizza{name='Margarita', size=30}

  }

}
