package lesson03;

public class While {
  public static void main1(String[] args) {
    int x = 0;

    while (x < 5) {
      System.out.println("hello");
      x++;
    }
    // hello x = 0
    // hello x = 1
    // hello x = 2
    // hello x = 3
    // hello x = 4
  }

  public static void main2(String[] args) {
    int x = 0;

    while (true) {
      if (x >= 5) break;
      System.out.println("hello");
      x++;
    }
  }

  public static void main3(String[] args) {
    int x = 0;

    while (true) {
      if (x >= 5) break;
      System.out.println("hello");
      x++;
      //
      if (x % 2 == 0) continue;
      //
      //
      //
    }
  }

  public static void main(String[] args) {
    int x = 0;

    do {
      System.out.println("hello");
      x++;
    } while (x < 0);
    // hello, 1+

  }
}
