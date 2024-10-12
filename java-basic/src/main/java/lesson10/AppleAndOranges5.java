package lesson10;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOranges5 {

  public static void countApplesAndOranges(
    int s, int t, int a, int b,
    List<Integer> apples,
    List<Integer> oranges) {

    BiFunction<Integer, List<Integer>, Long> counter =
      (center, distances) -> distances.stream()
          .filter(x -> x >= s && x <= t)
          .count();

    long apple_count = counter.apply(a, apples);
    long orange_count = counter.apply(b, oranges);
    System.out.printf("%d\n%d\n", apple_count, orange_count);
  }

}
