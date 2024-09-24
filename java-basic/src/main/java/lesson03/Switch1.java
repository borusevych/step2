package lesson03;

public class Switch1 {
  public static void main(String[] args) {
    int x = 10;

    switch (x) {
      case 1:
        System.out.println("one");
      case 3:
        System.out.println("three");
      case 5:
        System.out.println("five");
      case 10:
        System.out.println("ten");
      case 50:
        System.out.println("fifty");
      default:
        System.out.println("another");
    }
  }
}
