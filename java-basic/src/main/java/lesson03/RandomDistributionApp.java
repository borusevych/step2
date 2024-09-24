package lesson03;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomDistributionApp {
  public static void main(String[] args) {
    Map<Integer, Long> collected = Stream.generate(() -> (int) (Math.random() * 101))
      .limit(1_000_000)
      .collect(Collectors.groupingBy(
        Function.identity(),
        Collectors.counting()
      ));
      collected.forEach((n, c) -> System.out.printf("%d - %d\n", n, c));
  }
}
