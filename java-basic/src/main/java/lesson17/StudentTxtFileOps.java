package lesson17;

import java.io.*;
import java.util.List;

public class StudentTxtFileOps implements StudentDAO {

  private final String fileName;

  public StudentTxtFileOps(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void save(List<Student> xs) throws IOException {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(fileName)))) {
      for (Student p : xs) {
        w.write(p.represent());
        w.newLine();
      }
    }
  }

  @Override
  public List<Student> loadAll() throws IOException {
    try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
      return r.lines()
        .map(Student::fromString)
        .toList();
    }
  }


}
