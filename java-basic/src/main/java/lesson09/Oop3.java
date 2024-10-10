package lesson09;

public class Oop3 {

  static abstract class Animal{
    abstract void sound();
  }

  static class Cat extends Animal{
    @Override
    void sound() {
      System.out.println("meow");
    }
  }

  static class Dog extends Animal{
    @Override
    void sound() {
      System.out.println("gav");
    }
  }

  static void whatever(Animal x) {
    x.sound();
  }

  public static void main(String[] args) {
    Animal a = new Animal() {
      @Override
      void sound() {
        System.out.println("a-ha");
      }
    };

  }

}
