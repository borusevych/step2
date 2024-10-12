package lesson10;

import java.util.ArrayList;

public class Collections1 {

  public static void main(String[] args) {
    ArrayList<Integer> xs = new ArrayList<Integer>();
    // 1
    xs.add(10);
    xs.add(20);
    xs.add(30);
    System.out.println(xs); // [10, 20, 30]
    System.out.println(xs.size()); // 3
    System.out.println(xs.isEmpty()); // false
    xs.get(2); // 30
    xs.set(0, 100);
    System.out.println(xs); // [100, 20, 30]
    System.out.println(xs.contains(100));// true
    System.out.println(xs.contains(200));// false
    xs.getFirst();
    xs.getLast();
    xs.removeFirst();
    xs.removeLast();
  }

}
