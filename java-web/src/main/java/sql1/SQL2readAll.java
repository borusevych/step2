package sql1;

import lombok.SneakyThrows;

import java.sql.Connection;

public class SQL2readAll {

  @SneakyThrows
  public static void main(String[] args) {
    Connection connection = Conn.make();
    DAO<Student> dao = new DAOStudentSQL(connection);

    dao.loadAll().forEach(System.out::println);
  }
}
