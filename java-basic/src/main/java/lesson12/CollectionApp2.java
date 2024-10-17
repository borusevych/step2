package lesson12;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionApp2 {

  public static void main(String[] args) {

    ArrayList<String> l1 = new ArrayList<>();
    l1.add("Tesla");
    l1.add("Jeep");
    l1.add("Mazda");

    for (int i = 0; i < l1.size(); i++) {
      System.out.println(l1.get(i));
    }

    // single-used
    Iterator<String> it = l1.iterator();
    while (it.hasNext()) {
      String x = it.next();
      System.out.println(x);
    }

    for (Iterator<String> it0 = l1.iterator(); it0.hasNext(); ) {
      String x = it0.next();
      System.out.println(x);
    }

    for (String x : l1) {
      System.out.println(x);
    }



  }
}
