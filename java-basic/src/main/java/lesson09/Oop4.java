package lesson09;

public class Oop4 {

  interface Smart {
    int think();
  }
  interface Electro {
    void charge();
  }

  static abstract class Car {
    abstract void run();
  }
  static class Mazda extends Car {
    @Override
    void run() {
      System.out.println("Mazda is running");
    }
  }
  static class Ford extends Car {
    @Override
    void run() {
      System.out.println("Ford is running");
    }
  }
  static class Tesla extends Car implements Smart , Electro{
    @Override
    public int think() {
      return 33;
    }

    @Override
    void run() {
      System.out.println("Tesla is running");
    }

    @Override
    public void charge() {
      System.out.println("Tesla is charging");
    }
  }

  static class Person implements Smart {
    @Override
    public int think() {
      return 10;
    }
  }
  static class Phone implements Smart {
    @Override
    public int think() {
      return 3;
    }
  }

  static void method1(Smart smart) {
    int x = smart.think();
  }

  static void method2(Car car) {
    car.run();
  }

  static void method3(Electro car) {
    car.charge();
  }

  public static void main(String[] args) {
    Tesla t = new Tesla();
    Person p = new Person();
    Ford f = new Ford();

    method1(t);
    method1(p);

    method2(t);
    method2(f);

    method3(t);

  }

}
