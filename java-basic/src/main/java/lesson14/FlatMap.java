package lesson14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
  public static void main(String[] args) {
//    List<Integer> list =
    Stream<Stream<Integer>> xxs =
      List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .stream()
        .map(x -> Stream.of(-x, x));
//        .collect(Collectors.toUnmodifiableList());

    var list =
      List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .stream()
        .flatMap(x -> Stream.of(-x, x))
        .collect(Collectors.toUnmodifiableList());

    System.out.println(list);
  }
}
