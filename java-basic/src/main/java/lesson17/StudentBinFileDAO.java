package lesson17;

import java.io.*;
import java.util.List;

public class StudentBinFileDAO implements StudentDAO {

  private final String fileName;

  public StudentBinFileDAO(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void save(List<Student> xs) throws IOException {
    try (var os = new ObjectOutputStream(new FileOutputStream(fileName))) {
      os.writeObject(xs);
    }
  }

  @Override
  public List<Student> loadAll() throws IOException, ClassNotFoundException {
    try(var is = new ObjectInputStream(new FileInputStream(fileName))){
      Object o = is.readObject();
      return (List<Student>) o;
    }
  }

}
