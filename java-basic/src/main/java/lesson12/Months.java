package lesson12;

import java.util.Iterator;

public class Months implements Iterable<String> {
  private static final String[] data = {
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  };

  @Override
  public Iterator<String> iterator() {
    return new Iterator<>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < data.length;
      }

      @Override
      public String next() {
        return data[index++];
      }
    };
  }

  static public Iterable<String> summer() {
    return () -> new Iterator<>() {
      int index = 5;
      @Override
      public boolean hasNext() {
        return index < 5 + 3;
      }

      @Override
      public String next() {
        return data[index++];
      }
    };
  }

}
