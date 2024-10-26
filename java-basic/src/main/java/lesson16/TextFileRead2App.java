package lesson16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class TextFileRead2App {

  public static void main(String[] args) throws IOException {
    String fileName = "data.txt";
    File f = new File(fileName);
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    Stream<String> lines = br.lines();
    lines.forEach(System.out::println);
  }

}
