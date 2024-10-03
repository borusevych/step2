package lesson06;

import lesson06.model.Pizza;

import java.time.LocalTime;

public class SemanticConstructors {

  public static void main(String[] args) {
    Pizza pizza = new Pizza("Margarita", 30);
    Pizza pizza2 = Pizza.of("Margarita", 30);
    Pizza pizza3 = Pizza.random();

    LocalTime lt1 = LocalTime.of(16, 30);
    LocalTime lt2 = LocalTime.parse("16:30");
    LocalTime lt4 = LocalTime.now();
//    LocalTime lt5 = LocalTime.from();
//    LocalTime lt6 = LocalTime.ofSecondOfDay()
  }

}
