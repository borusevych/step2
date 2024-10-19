package lesson13;

public class Calculator2 {

  public static int div(int a, int b) throws DivisionByZeroException {
    try {
      return a / b;
    } catch (ArithmeticException e) {
      throw new DivisionByZeroException();
    }
  }

}
