package lesson12;

public class RandomsApp {
  public static void main(String[] args) {
    Randoms rr = new Randoms(10, 100, 5);

    for (int r: rr) {
      System.out.println(r);
    }

  }
}
