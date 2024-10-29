package lesson17;

import java.io.*;
import java.util.List;

public class PizzaBinFileDAO implements PizzaDAO {

  private final String fileName;

  public PizzaBinFileDAO(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void save(List<Pizza> xs) throws IOException {
    try (var os = new ObjectOutputStream(new FileOutputStream(fileName))) {
      os.writeObject(xs);
    }
  }

  @Override
  public List<Pizza> loadAll() throws IOException, ClassNotFoundException {
    try(var is = new ObjectInputStream(new FileInputStream(fileName))){
      Object o = is.readObject();
      return (List<Pizza>) o;
    }
  }

}
