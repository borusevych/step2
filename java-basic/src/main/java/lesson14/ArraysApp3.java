package lesson14;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class ArraysApp3 {

  interface FilterFn {
    boolean test(int x);
  }

  static int[] collect(int[] xs, FilterFn fn) {
    int[] outcome = new int[xs.length];
    int idx = 0;
    for (int x : xs) {
      if (fn.test(x)) {
        outcome[idx++] = x;
      }
    }
    return Arrays.copyOfRange(outcome, 0, idx);
  }

  public static void main(String[] args) {
    int[] as =
      IntStream.generate(new IntSupplier() {
        @Override
        public int getAsInt() {
          return (int) (Math.random() * 101 - 50);
        }
      })
      .limit(20)
      .toArray();
    int[] as2 = IntStream.generate(() -> (int) (Math.random() * 101 - 50))
      .limit(20)
      .toArray();

    var f1a = new FilterFn() {
      @Override
      public boolean test(int x) {
        return x < 0;
      }
    };

    FilterFn f1b = (int x) -> {
      return x < 0;
    };

    FilterFn f1c = x -> {
      return x < 0;
    };

    FilterFn f1d = x ->
      x < 0;

    FilterFn f1e = x -> x < 0;

    var f2 = new FilterFn() {
      @Override
      public boolean test(int x) {
        return x > 0;
      }
    };

    var f3 = new FilterFn() {
      @Override
      public boolean test(int x) {
        return x % 2 == 0;
      }
    };

    int[] as5 = collect(as, f1a);
    int[] as3 = collect(as, x -> x > 0);
    int[] as4 = collect(as, f3);


    System.out.println(Arrays.toString(as));
    System.out.println(Arrays.toString(as2));

    int[] xxs = {1,2,3,4,5};
    Arrays.stream(xxs);



  }

}
