package lesson02;

import java.util.Scanner;

public class CalculatorApp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter first number: ");
    String next1 = sc.next();
    int x = Integer.parseInt(next1);

    System.out.print("Enter second number: ");
    String next2 = sc.next();
    int y = Integer.parseInt(next2);

    var result = x + y;
    System.out.printf("The sum is: %s", result);
  }
}
