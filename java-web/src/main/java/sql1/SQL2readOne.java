package sql1;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.Optional;

public class SQL2readOne {

  @SneakyThrows
  public static void main(String[] args) {
    Connection connection = Conn.make();
    DAO<Student> dao = new DAOStudentSQL(connection);

    Optional<Student> s5 = dao.load(5);
    Optional<Student> s6 = dao.load(6);
    System.out.println(s5);
    System.out.println(s6);
  }
}
