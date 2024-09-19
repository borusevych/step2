package lesson02;

public class DataTypes {

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    int l = a.length;
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6, 7},
      {8, 9},
      {}
    };
    byte b = 127;
    int x = 5;
    long card = 1234_5678_9101_1112L;
    double y = 3.1415;
    char z = 'a'; // 1 byte
    char w = 'ш'; // 2 bytes
    char j = '你'; // 3 bytes
//    char c4 = '😀';
    String c4 = "\uD83D\uDE00"; // 4 bytes
    String s = "hello";
    boolean t = true;
    boolean bigger = 3 > 5; // false


    System.out.println(j);
    System.out.println(c4);

  }

}
