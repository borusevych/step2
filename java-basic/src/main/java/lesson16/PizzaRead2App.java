package lesson16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class PizzaRead2App {

  public static void main(String[] args) throws IOException {
    File f = new File("data21.txt");
    try (BufferedReader r = new BufferedReader(new FileReader(f))) {
      r.lines()
        .map(Pizza::fromString)
        .forEach(System.out::println);
    }
  }

}
