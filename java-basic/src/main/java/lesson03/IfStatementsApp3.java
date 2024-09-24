package lesson03;

import java.util.Scanner;

public class IfStatementsApp3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number greater than 100 and less than 1000: ");
    String next = sc.next();
    int x = Integer.parseInt(next);

    if (x < 100 && x > 1000) {
      System.out.printf("great, number %d given", x);
    } else {
      System.out.printf("bad, %d given", x);
    }


  }
}
