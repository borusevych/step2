package lesson16;

import java.io.*;

public class PizzaReadApp {

  public static void main(String[] args) throws IOException {
    File f = new File("data21.txt");
    try(BufferedReader r = new BufferedReader(new FileReader(f))) {
      while (true) {
        String line = r.readLine();
        if (line == null) break;
        Pizza p = Pizza.fromString(line);
        System.out.println(p);
      }
    }
  }

}
