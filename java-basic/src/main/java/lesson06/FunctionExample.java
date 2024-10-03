package lesson06;

public class FunctionExample {

  private int delta;

//  function (no access to closure)
//  static int add1(int x, int y) {
//    return x + y + delta;
//  }
//  function (no access to closure)
  static int add1(int x, int y) {
    return x + y;
  }

  // method. has access to class closure
  int add(int x, int y) {
    return x + y + delta;
  }

}
