package lesson05;

import java.util.Arrays;

public class StringConcatenation {

  static String[] xs = new String[] {
    "abc",
    "qwe",
    "asdf",
    "zxcv"
  };

  public static void concatenation1() {
    String outcome = "";
    for (String x : xs) {
      outcome += x;
    }
    System.out.println(outcome);
    // abc
    // abcqwe
    // abcqweasdf
    // abcqweasdfzxcv
  }

  public static void concatenation2() {
    int size = 0;
    for (String x : xs) {
      size += x.length();
    }
    System.out.println(size);
    char[] chars = new char[size];
    int idx = 0;
    for (String x : xs) {
      for(char c: x.toCharArray())
        chars[idx++] = c;
    }
    String outcome = new String(chars);
    System.out.println(outcome);
    // abcqweasdfzxcv
  }

  public static void concatenation3() {
    String outcome = String.join(" -> ", xs);
    System.out.println(outcome);
    // abc -> qwe -> asdf -> zxcv
  }

  static String showArray2(int[] as) {
    var strings = new String[as.length];
    for (int i = 0; i < as.length; i++) {
      strings[i] = String.valueOf(as[i]);
    }
    return String.join(", ", strings);
  }

  static String showArray3(int[] as) {
    var sb = new StringBuilder();
    for (int i = 0; i < as.length; i++) {
      if (i > 0) sb.append(", ");
      sb.append(as[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
//    concatenation1();
//    concatenation2();
//    concatenation3();
    int[] xs = {11,22,33};
    System.out.println(showArray2(xs));
    System.out.println(showArray3(xs));
    System.out.println(Arrays.toString(xs));
  }

}
