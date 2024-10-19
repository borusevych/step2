package lesson13;

public class ExApp1 {

  static void example1() {
    int a = 1;
    int b = 0;
    int c = a / b;
    System.out.printf("hello %d", c);
  }

  static void example2() {
    String s = "abc";
    int i = Integer.parseInt(s);
    int k = i + 1;
    System.out.printf("%d", k);
  }

  public static void main(String[] args) {
//    example1();
    example2();
  }

}
