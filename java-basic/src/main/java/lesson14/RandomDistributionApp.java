package lesson14;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomDistributionApp {
  public static void main(String[] args) {
    List<Integer> list = Stream.generate(() -> (int) (Math.random() * 50))
      .distinct()
      .limit(20)
      .toList();
    System.out.println(list);
  }
}
