package lesson16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PizzaWriteApp {

  public static void main(String[] args) throws IOException {
    Pizza p = new Pizza("Margarita", 30);

    File f = new File("data21.txt");
    try(BufferedWriter w = new BufferedWriter(new FileWriter(f))) {
      w.write(p.represent());
      w.newLine();
    }
  }

}
