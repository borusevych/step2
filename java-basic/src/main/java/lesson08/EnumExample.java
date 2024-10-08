package lesson08;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

enum Status {
  Placed,
  Paid,
  Shipped,
  Delivered
}

enum Color {
  Red,
  Yellow,
  Green
}

public class EnumExample {

  static void print(String color) {
    // "Red"
    // "RED"
    // "red"
    // "ReD"
  }

  static void print(int color) {
    // 1 - "Red"
    // 2 - "Yellow"
  }

  static void print(Color color) {
    switch (color) {
      case Red -> System.out.println("Red");
      case Yellow -> System.out.println("Yellow");
      case Green -> System.out.println("Green");
    }
    // 1 - "Red"
    // 2 - "Yellow"
  }

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    DayOfWeek day = now.getDayOfWeek();
    Month month = now.getMonth();
    Color c = Color.Green;
    print(Color.Red);

  }
}
