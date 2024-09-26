package lesson04;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysApp2 {

  static void showArray(int[] as) {
    for (int i = 0; i < as.length; i++) {
      if (i > 0) System.out.print(",");
      System.out.printf("%d", as[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] as = IntStream.generate(() -> (int) (Math.random() * 101 - 50))
      .limit(20)
      .toArray();

    System.out.println(as); // [I@38af3868
    //                         ^
    //                          ^
    //                            --------
    showArray(as);
    System.out.println(Arrays.toString(as));
  }

}
