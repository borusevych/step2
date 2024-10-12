package lesson10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Collections4 {

  public static void main(String[] args) {
    HashSet<Integer> xs = new HashSet<>();
    xs.add(1);
    xs.add(2);
    xs.add(1);
    xs.remove(1);
    System.out.println(xs.size());
    System.out.println(xs);

    List<Integer> as = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 4, 2);
    //                               ----------------
    HashSet<Integer> unique = new HashSet<>(as);
    System.out.println(unique);


  }


}
