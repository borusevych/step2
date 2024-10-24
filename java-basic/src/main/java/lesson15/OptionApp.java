package lesson15;

import java.util.Optional;

public class OptionApp {

  public static Optional<Integer> toInt(String s) {
    try {
      int x = Integer.parseInt(s);
      return Optional.of(x);
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {
//    int i = Integer.parseInt("abc"); // exception
//    Integer i = maybeInt.get(); // NoSuchElementException

    Optional<Integer> maybeInt = toInt("abc"); // NO exception
    Integer x = maybeInt.orElse(123);


    Optional<String> o = Optional.ofNullable(null);

  }

}
