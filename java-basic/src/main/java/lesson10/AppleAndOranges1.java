package lesson10;

import java.util.List;

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOranges1 {

  static boolean isBetween(int x, int l, int r) {
    return x >= l && x <= r;
  }

  static int count(int s, int t, int center, List<Integer> distances) {
    int count = 0;
    for (int distance: distances) {
      count += isBetween(center + distance, s, t) ? 1 : 0;
//      if (isBetween(center + distance, s, t)) {
//        count++;
//      }
    }
    return count;
  }

  public static void countApplesAndOranges(
    int s, int t, int a, int b,
    List<Integer> apples,
    List<Integer> oranges) {

    int apple_count = count(s,t,a,apples);
    int orange_count = count(s,t,b,oranges);
    System.out.printf("%d\n%d\n", apple_count, orange_count);
  }

}
