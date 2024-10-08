package lesson08;

public class JavaMemory1 {

  static void process(int k) {
    System.out.printf("Processing %d\n", k);
    k = 100;
    System.out.printf("Processing %d\n", k);
  }


  public static void main(String[] args) {
    int x = 5;
    System.out.printf("Processing main %d\n", x);
    process(x);
    System.out.printf("Processing main %d\n", x);
  }

}
