package lesson03;

public class Envelope {

  public static void main(String[] args) {
    int W = 20;
    int H = 8;

    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {

        char c = x == 0 || x == W - 1 ||
                 y == 0 || y == H - 1    ? '*' : ' ';

        System.out.print(c);
      }
      System.out.println();
    }
  }
}
