package lesson09;

import lesson09.data.Animal;
import lesson09.data.Cat;

public class Oop2 {

  public static void main(String[] args) {
    Animal a = new Animal("mac");
    Cat c = new Cat("mac12");
    //c.eat();
//    c.meow();

    System.out.println(a instanceof Animal);
    System.out.println(c instanceof Cat);
    System.out.println(c instanceof Animal);
    System.out.println(c instanceof Object);
    a.sound(); // I'm Animal
    c.sound(); // I'm Cat
    c.parentSound(); // I'm Animal



  }

}
