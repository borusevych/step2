package lesson08;

import java.util.Arrays;

public class BoxSafe {
  private final int[] xs = {1,2,3};

  public int[] getXs() {
    return Arrays.copyOf(xs, xs.length);
  }

  @Override
  public String toString() {
    return "Box{" +
      "xs=" + Arrays.toString(xs) +
      '}';
  }
}
