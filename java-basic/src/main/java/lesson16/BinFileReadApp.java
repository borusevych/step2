package lesson16;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BinFileReadApp {

  public static void main(String[] args) throws IOException {
    String fileName = "data13.txt";
    File f = new File(fileName);
    FileReader fr = new FileReader(f);

    int b;
    while (true) {
      b = fr.read();
      if (b == -1) break;
      System.out.println(b);
    }
    fr.close();
  }

}
