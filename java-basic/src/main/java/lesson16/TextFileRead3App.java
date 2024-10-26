package lesson16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFileRead3App {

  public static void main(String[] args) throws IOException {
    String fileName = "data.txt";
    File f = new File(fileName);
    FileReader fr = new FileReader(f);

    try (BufferedReader br = new BufferedReader(fr)) {
      String s;

      while (true) {
        s = br.readLine();
        if (s == null) break;
        System.out.println(s);
      }
    }
  }

}
