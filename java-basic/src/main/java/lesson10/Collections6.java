package lesson10;

import java.util.HashSet;

public class Collections6 {

  public static void main(String[] args) {

    HashSet<Short> xs = new HashSet<>();

    for (short i = 0; i < 100; i++) {
      xs.add(i);
      short one = 1;

      int x = i - one;
      xs.remove(x);
    }

    System.out.println(xs.size());
  }

}
