package lesson16;

import java.io.*;

public class ObjectsFileWriteApp {

  public static void main(String[] args) throws IOException {
    String fileName = "data17.obj";
    File f = new File(fileName);
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
      oos.writeBoolean(true);
      oos.writeByte(33);
      oos.writeObject(new Pizza("Mar", 30));
    }
  }

}
