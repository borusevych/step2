package lesson16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BinFileWriteApp {

  public static void main(String[] args) throws IOException {
    String fileName = "data13.txt";
    File f = new File(fileName);
    FileWriter fw = new FileWriter(f);
    fw.write(97);
    fw.write(13);
    fw.write(65);
    fw.close();
  }

}
