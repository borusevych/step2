package lesson15;

import java.util.Optional;

public class OptionMethods2 {

  public static void main(String[] args) {
//    Optional<Integer> ox = Optional.of(1); // of(1)
    Optional<Integer> ox = Optional.empty(); // of(1)

    ox.ifPresentOrElse(
      x -> System.out.printf("The value inside: %d\n", x),
      () -> System.out.println("There is no value inside")
    );


    String outcome =
      ox.map(x -> String.format("The value inside: %d\n", x)) // Optional<String>
        .orElse("There is no value inside");

    System.out.println(outcome);

  }

}
