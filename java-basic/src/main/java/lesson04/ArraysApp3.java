package lesson04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysApp3 {

  static int[] collectNegatives1(int[] xs) {
    // count negatives
    int nc = 0;
    for (int i = 0; i < xs.length; i++) {
      if (xs[i] < 0) nc++;
    }
    // collect negatives
    int[] outcome = new int[nc];
    int idx = 0;
    for (int i = 0; i < xs.length; i++) {
      if (xs[i] < 0) {
        outcome[idx] = xs[i];
        idx++;
      }
    }
    return outcome;
  }

  interface FilterFn {
    boolean test(int x);
  }

  static int[] collect(int[] xs, FilterFn fn) {
    int[] outcome = new int[xs.length];
    int idx = 0;
    for (int i = 0; i < xs.length; i++) {
      if (fn.test(xs[i])) {
        outcome[idx] = xs[i];
        idx++;
      }
    }
    return Arrays.copyOfRange(outcome, 0, idx);
  }

  static int[] collect2(int[] xs, FilterFn fn) {
    int[] outcome = new int[xs.length];
    int idx = 0;
    for (int x : xs) {
      if (fn.test(x)) {
        outcome[idx++] = x;
      }
    }
    return Arrays.copyOfRange(outcome, 0, idx);
  }

  static int[] collectNegatives3(int[] xs) {
    var fn = new FilterFn() {
      @Override
      public boolean test(int x) {
        return x < 0;
      }
    };
    return collect(xs, fn);
  }

  static int[] collectNegatives4(int[] xs) {
    FilterFn fn = (int x) -> {
      return x < 0;
    };
    return collect(xs, fn);
  }

  static int[] collectNegatives5(int[] xs) {
    FilterFn fn = (int x) -> x < 0;
    return collect(xs, fn);
  }

  static int[] collectNegatives6(int[] xs) {
    FilterFn fn = (x) -> x < 0;
    return collect(xs, fn);
  }

  static int[] collectNegatives7(int[] xs) {
    FilterFn fn = x -> x < 0;
    return collect(xs, fn);
  }

  static int[] collectNegatives8(int[] xs) {
    return collect(xs, x -> x < 0);
  }

  static int[] collectPositives(int[] xs) {
    return collect(xs, x -> x >= 0);
  }

  public static void main(String[] args) {
    int[] as = IntStream.generate(() -> (int) (Math.random() * 101 - 50))
      .limit(20)
      .toArray();

    int[] bs = collectNegatives1(as);
    int[] cs = collectNegatives8(as);
    int[] ds = collectPositives(as);

    System.out.println(Arrays.toString(as));
    System.out.println(Arrays.toString(bs));
    System.out.println(Arrays.toString(cs));
    System.out.println(Arrays.toString(ds));
  }

}
