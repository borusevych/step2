package lesson08;

import java.util.Arrays;

public class JavaMemory3 {

  static void process(int[] ks) {
    System.out.printf("Processing main %s\n", Arrays.toString(ks));
    ks[1] = 100;
    System.out.printf("Processing main %s\n", Arrays.toString(ks));
  }

  public static void main(String[] args) {
    int[] xs = {1,2,3};
    System.out.printf("Processing main %s\n", Arrays.toString(xs));
    process(xs);
    System.out.printf("Processing main %s\n", Arrays.toString(xs));
  }

}
