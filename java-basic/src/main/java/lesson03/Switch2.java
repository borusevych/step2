package lesson03;

public class Switch2 {
  public static void main(String[] args) {
    int x = 10;

    switch (x) {
      case 1:
        System.out.println("one");
        break;
      case 3:
        System.out.println("three");
        break;
      case 5:
        System.out.println("five");
        break;
      case 10:
        System.out.println("ten");
        break;
      case 50:
        System.out.println("fifty");
        break;
      default:
        System.out.println("another");
    }
  }
}
