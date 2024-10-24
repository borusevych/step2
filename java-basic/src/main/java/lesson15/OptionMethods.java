package lesson15;

import java.util.Optional;

public class OptionMethods {

  public static void main(String[] args) {
    //  Integer | empty
    Optional<Integer> ox = Optional.of(1); // of(1)

    Optional<Integer> oy = ox.filter(x -> x > 10); // empty

    Optional<Integer> oz = ox.map(x -> x * 2); // of(2)

    ox
      .map(x -> x * 2)
      .filter(x -> x > 10); // empty

    ox
      .map(x -> x * 2)
      .map(x -> x * 2)
      .map(x -> x * 2)
      .map(x -> x * 2)
      .filter(x -> x > 10); // of(16)

    Optional<Optional<Integer>> ox1 = ox.map(x -> Optional.of(x));
    Optional<Integer> ox2 = ox.flatMap(x -> Optional.of(x)); // 1
    Optional<Integer> ox3 = ox.flatMap(x -> Optional.empty()); // Empty

    ox.ifPresent(x -> System.out.println(x)); // void
    ox.ifPresentOrElse(
      x -> System.out.printf("The value inside: %d\n", x),
      () -> System.out.println("There is no value inside")
    );



  }

}
