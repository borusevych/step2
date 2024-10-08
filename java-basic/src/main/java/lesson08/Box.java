package lesson08;

import java.util.Arrays;

public class Box {
  final int[] xs = {1,2,3};

  @Override
  public String toString() {
    return "Box{" +
      "xs=" + Arrays.toString(xs) +
      '}';
  }
}
