package lesson06;

public class Utils {

  public static String[] combine(String x, String... xs) {
    var xs2 = new String[xs.length + 1];
    xs2[0] = x;
    if (xs.length != 0) {
      System.arraycopy(xs, 0, xs2, 1, xs.length);
    }
    return xs2;
  }

}
