package lesson03;

import java.util.Random;

public class RandomsSeedApp {
  // 5 -1 -5 -3 10 -9 10 9 9 9 -1 -2 -3 0 -7 6 3 -6 -2 -7 4 6 -9 0 5 -7 0 1 2 -5 3 -6 -9 -6 -6 1 10 -4 -1 -5 0 -5 8 -9 2 3 -7 3 10 -5 -2 0 -2 0 0 10 3 9 0 0 0 -3 5 10 -5 -6 1 1 2 6 4 -5 -4 6 -5 10 6 7 -6 3 -9 3 -5 8 4 5 0 10 -6 4 7 -7 2 0 -7 2 -9 2 -8 -8
  // 5 -1 -5 -3 10 -9 10 9 9 9 -1 -2 -3 0 -7 6 3 -6 -2 -7 4 6 -9 0 5 -7 0 1 2 -5 3 -6 -9 -6 -6 1 10 -4 -1 -5 0 -5 8 -9 2 3 -7 3 10 -5 -2 0 -2 0 0 10 3 9 0 0 0 -3 5 10 -5 -6 1 1 2 6 4 -5 -4 6 -5 10 6 7 -6 3 -9 3 -5 8 4 5 0 10 -6 4 7 -7 2 0 -7 2 -9 2 -8 -8
  public static void main(String[] args) {
    Random random = new Random(1);
    for (int i = 0; i < 100; i++) {
      int x = (int) (random.nextDouble() * 21 - 10);
      System.out.printf("%d ", x);
    }
  }
}
