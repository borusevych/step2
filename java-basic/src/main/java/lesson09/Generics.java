package lesson09;

import lesson07.Pizza;

public class Generics {

  static class Box<A> {
    A x;

    public Box(A x) {
      this.x = x;
    }
  }


  static class BoxInt {
    int x;

    public BoxInt(int x) {
      this.x = x;
    }
  }

  static class BoxDouble {
    double x;

    public BoxDouble(double x) {
      this.x = x;
    }
  }

  static class BoxBoolean {
    boolean x;

    public BoxBoolean(boolean x) {
      this.x = x;
    }
  }




  public static void main(String[] args) {
    BoxInt boxInt = new BoxInt(11);
    BoxDouble boxDouble = new BoxDouble(3.5);

    Box<Integer> box1a = new Box<Integer>(1);
    Box<Integer> box1b = new Box<>(1);
    new Box<>(1);
    Box<Pizza> box2 = new Box<Pizza>(new Pizza("Margarita"));
  }

}
