package lesson06;

public class Overload {

  static int add(int a, int b) {
    return a + b;
  }

  static int add(int a, int b, int c) {
    return a + b + c;
  }

  static long add(long a, long b) {
    return a + b;
  }

  public static void main(String[] args) {
    int a = 1; //int
    var x = add(1, 2L);
  }

}
