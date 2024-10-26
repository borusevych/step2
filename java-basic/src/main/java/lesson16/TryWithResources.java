package lesson16;

public class TryWithResources {

  static class MyThing implements AutoCloseable {

    @Override
    public void close() {
      System.out.println("closing my thing...");
    }

  }

  public static void main(String[] args) {

    System.out.println("begin");
    try (var myThing = new MyThing()) {
      System.out.println("...");
    }
    System.out.println("done");

  }


}
