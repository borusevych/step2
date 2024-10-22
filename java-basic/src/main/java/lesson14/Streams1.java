package lesson14;

import java.util.List;
import java.util.stream.Collectors;

public class Streams1 {

  public static void main(String[] args) {

    List<Integer> xs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    int c = 0;
    for (int x : xs) {
      if (x > 2) {
        c++;
        if (c<5) {
          String y = String.format("%d^2 = %d", x, x * x);
          System.out.println(y);
        }
      }
    }

    xs.stream()
      .filter(x -> x > 2)
      .map(x -> String.format("%d^2 = %d", x, x * x))
      .forEach(x -> System.out.println(x));

    List<Integer> ys = xs.stream()
      .filter(x -> x > 2)
      .limit(5)
      .collect(Collectors.toList());

    List<Integer> zs = xs.stream()
      .map(x -> x * x)
      .filter(x -> x > 10)
      .limit(5)
      .collect(Collectors.toList());


  }

}
