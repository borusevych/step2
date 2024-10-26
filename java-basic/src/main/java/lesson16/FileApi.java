package lesson16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class FileApi {

  public static void main(String[] args) throws IOException {
    String fileName = "data18.obj";
    File f = new File(fileName);
    f.canRead();
    f.delete();
    f.isDirectory();
    f.getAbsolutePath();
    f.mkdir();
  }

}
