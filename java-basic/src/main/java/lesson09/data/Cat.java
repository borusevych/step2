package lesson09.data;

public class Cat extends Animal {

  public Cat(String name) {
    super(name); // new Animal (call Animal constructor)
  }

  @Override
  public void sound() {
//    meow();
//    System.out.println("I'm Cat");
    eat();
  }

  public void parentSound() {
    super.sound();
  }

  protected void meow() {
    System.out.println("Meow");
  }

  private void eat() {
    System.out.println("I'm eating");
  }
}