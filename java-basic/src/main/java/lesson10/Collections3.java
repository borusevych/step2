package lesson10;

import java.util.ArrayList;
import java.util.List;

public class Collections3 {

  public static void main(String[] args) {
    List<String> xs = new ArrayList<>();
    // 1
    xs.add("10");//0
    xs.add("20");//1
    xs.add("30");//2
    System.out.println(xs); // ["10", "20", "30"]
    // xs.remove(10); // java.lang.IndexOutOfBoundsException
    xs.remove("10");
    System.out.println(xs); // ["20", "30"]

    for (String x : xs) {
      System.out.printf(">%s<\n",x);
    }

  }


}
