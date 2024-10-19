package lesson13;

import java.util.Scanner;

public class Calculator2App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    int a = Integer.parseInt(s1);
    int b = Integer.parseInt(s2);

    try {
      int c = Calculator2.div(a, b);
      System.out.println(c);
    } catch (ArithmeticException e) {
      System.out.println("can't divide by zero");
    } catch (DivisionByZeroException e) {
      System.out.println("can't divide by zero !!!");
    }

  }


}
