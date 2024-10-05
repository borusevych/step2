package lesson07;

import java.util.function.Function;

public class Rhombus {

  public static boolean[][] rhombus(int N) {
    //                                  input    output
    interface MirrorFn extends Function<Integer, Integer>{}
    MirrorFn f = x -> N - 1 - x;
    int half = N / 2;
    boolean[][] r = new boolean[N][N];
    for (int y = 0; y < N; y++) {
      for (int x = 0; x < N; x++) {
        boolean q1 = (        x  +         y  < half);
        boolean q2 = (f.apply(x) +         y  < half);
        boolean q3 = (        x  + f.apply(y) < half);
        boolean q4 = (f.apply(x) + f.apply(y) < half);
        boolean isWhite = q1 || q2 || q3 || q4;
        r[y][x]= !isWhite;
      }
    }
    return r;
  }

  public static void main(String[] args) {
    boolean[][] rhomb = rhombus(11);
    for (boolean[] row : rhomb) {
      for (boolean isBlack : row) {
        System.out.print(isBlack ? "*" : " ");
      }
      System.out.println();
    }
  }

}
