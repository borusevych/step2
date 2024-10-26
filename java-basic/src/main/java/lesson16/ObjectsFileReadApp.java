package lesson16;

import java.io.*;

public class ObjectsFileReadApp {

  public static void main(String[] args) throws IOException {
    String fileName = "data17.obj";
    File f = new File(fileName);
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
      boolean b = ois.readBoolean();
      byte b1 = ois.readByte();
      Object o = ois.readObject();
      Pizza pizza = (Pizza) o; // could be an exception: ClassCastException
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

}
