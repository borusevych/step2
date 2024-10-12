package lesson10;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOranges3 {

  static boolean isBetween(int x, int l, int r) {
    return x >= l && x <= r;
  }

  public static void countApplesAndOranges(
    int s, int t, int a, int b,
    List<Integer> apples,
    List<Integer> oranges) {

    interface Counter extends BiFunction<Integer, List<Integer>, Integer> {}
    interface IsBetween extends Function<Integer, Boolean> {}

    IsBetween isBetween = x -> x >= s && x <= t;

    Counter c = (Integer center, List<Integer> distances) -> {
      int count = 0;
      for (int distance : distances)
        if (isBetween.apply(center + distance)) count++;
      return count;
    };

    int apple_count = c.apply(a, apples);
    int orange_count = c.apply(b, oranges);
    System.out.printf("%d\n%d\n", apple_count, orange_count);
  }

}
