package lesson15;

import java.util.Scanner;

public class Calc {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter x:");
    String xs = sc.next();
    System.out.print("Enter y:");
    String ys = sc.next();

    try {
      int x = Integer.parseInt(xs);
      int y = Integer.parseInt(ys);

      int z = x + y;

      String s = String.format("%d + %d = %d", x, y, z);
      System.out.println(s);
    } catch (NumberFormatException e) {
      System.out.println("something went wrong");
    }
  }

}
