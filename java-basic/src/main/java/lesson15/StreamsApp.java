package lesson15;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamsApp {

  <A extends Comparable<A>> A min(NonEmptyArray<A> as) {
    A min = as.head();
    for (A a: as) {
      if (a.compareTo(min) < 0) {
        min = a;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    Optional<Integer> first = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
      .filter(x -> x % 13 == 0)
      .findFirst();

    System.out.println(first);

    var xs = new NonEmptyArray<>(11, new Integer[]{22, 33, 44});

    for (int x : xs) {
      System.out.println(x);
    }

  }
}
