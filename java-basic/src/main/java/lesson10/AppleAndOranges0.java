package lesson10;

import java.util.List;

// https://www.hackerrank.com/challenges/apple-and-orange/problem
public class AppleAndOranges0 {

  public static void countApplesAndOranges(
    int s, int t, int a, int b,
    List<Integer> apples,
    List<Integer> oranges) {

    int apple_count = 0;
    for (int distance : apples) {
      int pos = a + distance;
      if (pos >= s && pos <= t) {
        apple_count++;
      }
    }

    int orange_count = 0;
    for (int distance : oranges) {
      int pos = b + distance;
      if (pos >= s && pos <= t) {
        orange_count++;
      }
    }

    System.out.printf("%d\n%d\n", apple_count, orange_count);
  }

}
