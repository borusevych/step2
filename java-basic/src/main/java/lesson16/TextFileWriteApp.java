package lesson16;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriteApp {

  public static void main(String[] args) throws IOException {
    String fileName = "data.txt";
    File f = new File(fileName);
    FileWriter fw = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("Hello from Java!");
    bw.close();
  }

}
