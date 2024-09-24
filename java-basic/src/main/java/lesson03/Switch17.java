package lesson03;

public class Switch17 {
  public static void main(String[] args) {
    int x = 10;

    String message = switch (x) {
      case 1 -> "one";
      case 3 -> "three";
      case 5 -> "five";
      case 10 -> "ten";
      case 50 -> "fifty";
      default -> "another";
    };
  }
}
