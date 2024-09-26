package lesson04;

public class ArraysApp4 {

  static int min(int[] xs) {
    int m = xs[0];
    for (int x : xs) {
      m = Math.min(m, x);
    }
    return m;
  }

  public static void main(String[] args) {
    int[] xs = {1, 5, 2, 9};
    int min = min(xs);
    System.out.println(min);

    int[] ys = {};
    int min2 = min(ys);
    System.out.println(min2);
  }

}
