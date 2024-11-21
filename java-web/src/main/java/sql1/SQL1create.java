package sql1;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.List;

public class SQL1create {

  @SneakyThrows
  public static void main(String[] args) {
    Connection connection = Conn.make();
    DAO<Student> dao = new DAOStudentSQL(connection);

    dao.save(List.of(
      new Student(null, "Jack", 33),
      new Student(null, "John", 34)
    ));
  }
}
