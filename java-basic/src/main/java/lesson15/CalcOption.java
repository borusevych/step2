package lesson15;

import java.util.Optional;
import java.util.Scanner;

import static lesson15.OptionApp.toInt;

public class CalcOption {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter x:");
    String xs = sc.next();
    System.out.print("Enter y:");
    String ys = sc.next();

    Optional<Integer> maybeX = toInt(xs);
    Optional<Integer> maybeY = toInt(ys);

    Optional<Integer> maybeSum =
      maybeX
        .flatMap(x ->
          maybeY.map(y -> x + y)
        );

    String s = maybeSum.map(z -> String.format("The sum is: %d", z))
      .orElse("something went wrong");

    System.out.println(s);
  }

}
