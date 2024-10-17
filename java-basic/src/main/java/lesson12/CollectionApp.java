package lesson12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionApp {

  public static void main(String[] args) {
    int[] a = {10, 20, 30};
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }

    for (int x : a) {
      System.out.printf("element: %d\n", x);
    }

    ArrayList<String> l1 = new ArrayList<>();
    l1.add("Tesla");
    l1.add("Jeep");
    l1.add("Mazda");
    for (String x : l1) {
      System.out.println(x);
    }

    Set<Double> l2 = new HashSet<>();
    l2.add(Math.PI);
    l2.add(Math.E);
    for (double x : l2) {
      System.out.println(x);
    }

    Months months = new Months();

    Iterator<String> it = months.iterator();
    while (it.hasNext()) {
      String x = it.next();
      System.out.println(x);
    }

    for (String m: months) {
      System.out.println(m);
    }

    months.forEach(x -> System.out.println(x));




  }

}
