package lesson10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Collections5 {

  public static void main(String[] args) {

    // 0..15
    for (int i = 0; i < 10; i++) {
      int n = (int) (Math.random() * 16);
      System.out.printf("%d ", n);
    }
    System.out.println();

    HashSet<Integer> xs = new HashSet<>();
    while (xs.size() < 10) {
      int n = (int) (Math.random() * 16);
      xs.add(n);
    }
    System.out.println(xs);


  }


}
