package lesson03;

import java.util.Scanner;

public class IfStatementsApp1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number less than 100: ");
    String next = sc.next();
    int x = Integer.parseInt(next);

    if (x < 100) {
      System.out.printf("great, number %d given", x);
    } else {
      System.out.printf("bad, %d given", x);
    }
  }
}
