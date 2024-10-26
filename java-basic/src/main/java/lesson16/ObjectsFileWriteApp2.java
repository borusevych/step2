package lesson16;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class ObjectsFileWriteApp2 {

  public static void main(String[] args) throws IOException {
    String fileName = "data18.obj";
    File f = new File(fileName);
    List<Pizza> pizzas = Arrays.asList(
      new Pizza("M1", 31),
      new Pizza("M2", 32),
      new Pizza("M3", 33)
    );

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
      oos.writeObject(pizzas);
    }
  }

}
