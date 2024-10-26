package lesson16;

import java.io.*;

public class TextFileRead1App {

  public static void main(String[] args) throws IOException {
    String fileName = "data.txt";
    File f = new File(fileName);
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);

    // br.readLine(); // null when empty
    String s;

//    while ((s = br.readLine()) != null) {
//      System.out.println(s);
//    }

    while (true) {
      s = br.readLine();
      if (s == null) break;
      System.out.println(s);
    }


    br.close();

  }

}
