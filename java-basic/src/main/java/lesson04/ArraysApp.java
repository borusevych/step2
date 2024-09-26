package lesson04;

public class ArraysApp {

  public static void main1(String[] args) {
    int[] a = {10, 20, 30};

    for (int i = 0; i < a.length; i++) {
      int x = a[i];
      System.out.printf("index: %d, element: %d\n", i, x);
    }
    System.out.println();
    // index: 0, element: 10
    // index: 1, element: 20
    // index: 2, element: 30

    int idx = 0;
    while (idx < a.length) {
      int x = a[idx];
      System.out.printf("index: %d, element: %d\n", idx, x);
      idx++;
    }
    System.out.printf("idx = %d\n", idx);

    for (int i = 0; i < a.length; i++) {
      a[i]++;
    }

    for (int i = 0; i < a.length; i++) {
      int x = a[i];
      System.out.printf("index: %d, element: %d\n", i, x);
    }
    System.out.println();
    // index: 0, element: 11
    // index: 1, element: 21
    // index: 2, element: 31
  }

  public static void main2(String[] args) {
    int[][] a = {
      {1, 2, 3},
      {4, 5, 6, 7},
      {8, 9},
      {}
    };

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.printf("a[%d][%d]=%d ", i, j, a[i][j]);
      }
      System.out.println(".");
    }
  }

  public static void main(String[] args) {
    int[] a = {10, 20, 30};

    for (int x : a) {
      System.out.printf("element: %d\n", x);
    }
  }

}
