package lesson12;

import java.util.Comparator;

public class ComparatorVsComparable {

  record Box(int x) implements Comparable<Box> {
    @Override
    public int compareTo(Box that) {
      return compBox.compare(this, that);
    }
  }

  static Comparator<Box> compBox = new Comparator<>() {
    @Override
    public int compare(Box o1, Box o2) {
      return o1.x - o2.x;
    }
  };

  public static void main(String[] args) {

    Comparator<Box> compBox2 = new Comparator<>() {
      @Override
      public int compare(Box o1, Box o2) {
        return o1.compareTo(o2);
      }
    };


  }


}
