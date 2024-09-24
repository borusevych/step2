package lesson03;

public class ForLoop {

  public static void main1(String[] args) {

    for (int i = 1; i <= 5; i++) {
      System.out.println(i);
    }

    int i = 1;
    for (; i <= 5; i++) {
      System.out.println(i);
    }

    for (; ; i++) {
      if (i > 10) break;
      System.out.println(i);
    }

    for (;;) {
      if (i > 15) break;
      System.out.println(i);
      i++;
    }
  }

  public static void main3(String[] args) {
    int i = 1;
    while (i <= 5) {
      System.out.println(i);
      i++;
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      for (char j = 'a'; j <= 'd'; j++) {
        System.out.printf("i=%d, j=%s\n", i, j);
      }
    }
  }

}
