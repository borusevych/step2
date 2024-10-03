package lesson06;

public class FunctionPlayground {

  public static void main(String[] args) {
    // static
    int i = FunctionExample.add1(1, 2);

    // non-static
    FunctionExample fx = new FunctionExample();

    // instance only
    int k = fx.add(1, 2);
    System.out.println(k);

//    fx.delta = 100;
    // instance only
    int k1 = fx.add(1, 2);
    System.out.println(k1);
  }

}
