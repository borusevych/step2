package lesson03;

import java.util.Scanner;

public class Ternary {
  public static void main_bad(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number greater than 100 and less than 1000: ");
    String next = sc.next();
    int x = Integer.parseInt(next);

    int k;

    if (x < 100) {
      k = 1;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number greater than 100 and less than 1000: ");
    String next = sc.next();
    int x = Integer.parseInt(next);

    int k = x < 100 ? 1 : 2;
  }
}
