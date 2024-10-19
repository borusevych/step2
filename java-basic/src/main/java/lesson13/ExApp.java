package lesson13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExApp {

  /// convert checked exception => non-checked exception
  static FileReader newFileReader(File file) {
    try {
      return new FileReader(file);
    } catch (FileNotFoundException e) { // catch checked
      throw new RuntimeException(e); // throw unchecked
    }
  }

  static void example1(String[] args) {
    File file = new File("1.txt");
    try {
      var r = new FileReader(file);
    } catch (FileNotFoundException e) {
      ///
      ///
      ///
    }
  }

  static void example2(String[] args) throws FileNotFoundException {
    File file = new File("1.txt");
    var r = new FileReader(file);
  }

  static void example3(String[] args) {
    File file = new File("1.txt");
    var r = newFileReader(file);
  }

}
