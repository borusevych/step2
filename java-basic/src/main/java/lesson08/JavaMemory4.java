package lesson08;

public class JavaMemory4 {

  static void process(Box b) {
    System.out.printf("Processing main %s\n", b);
//    b.xs = new int[]{1,2,3,4,5};
    b.xs[1] = 101;
    System.out.printf("Processing main %s\n", b);
  }

  public static void main(String[] args) {
    Box b = new Box();
    System.out.printf("Processing main %s\n", b);
    process(b);
    System.out.printf("Processing main %s\n", b);
  }

}
