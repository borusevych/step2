package lesson03;

public class Envelope {

  static boolean isDiagonal(int x, int y, int W, int H, double k) {
    return x == Math.floor(k * y) || W - x - 1 == Math.floor(k * y);
  }

  static boolean isHorizontal(int x, int y, int W, int H) {
    return x == 0 || x == W - 1;
  }

  static boolean isVertical(int x, int y, int W, int H) {
    return y == 0 || y == H - 1;
  }

  public static void main(String[] args) {
    int W = 72;
    int H = 17;
    double k = (double) W / H;

    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {

        char c =
          isHorizontal(x, y, W, H) ||
            isVertical(x, y, W, H) ||
            isDiagonal(x, y, W, H, k) ? '*' : ' ';

        System.out.print(c);
      }
      System.out.println();
    }
  }
}
