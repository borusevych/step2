package lesson10;

import java.util.List;

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOranges2 {

  static boolean isBetween(int x, int l, int r) {
    return x >= l && x <= r;
  }

  public static void countApplesAndOranges(
    int s, int t, int a, int b,
    List<Integer> apples,
    List<Integer> oranges) {

    interface Counter {
      int count(int center, List<Integer> distances);
    }

    Counter c = (int center, List<Integer> distances) -> {
      int count = 0;
      for (int distance : distances)
        if (isBetween(center + distance, s, t)) count++;
      return count;
    };

    int apple_count = c.count(a, apples);
    int orange_count = c.count(b, oranges);
    System.out.printf("%d\n%d\n", apple_count, orange_count);
  }

}
