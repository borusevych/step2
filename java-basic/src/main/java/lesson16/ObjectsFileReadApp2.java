package lesson16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectsFileReadApp2 {

  public static void main(String[] args) throws IOException {
    String fileName = "data18.obj";
    File f = new File(fileName);
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
      Object o = ois.readObject();
      List<Pizza> pizzas = (List<Pizza>) o;
      pizzas.forEach(p -> System.out.printf("%s %s\n", p.name, p.size));
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

}
