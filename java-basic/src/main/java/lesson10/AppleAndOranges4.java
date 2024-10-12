package lesson10;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOranges4 {

  public static void countApplesAndOranges(
    int s, int t, int a, int b,
    List<Integer> apples,
    List<Integer> oranges) {

    Predicate<Integer> isBetween = x -> x >= s && x <= t;

    BiFunction<Integer, List<Integer>, Integer> counter =
      (center, distances) -> {
        int count = 0;
        for (int distance : distances)
          if (isBetween.test(center + distance)) count++;
        return count;
      };

    int apple_count = counter.apply(a, apples);
    int orange_count = counter.apply(b, oranges);
    System.out.printf("%d\n%d\n", apple_count, orange_count);
  }

}
