package sql1;

import lombok.SneakyThrows;

import java.sql.Connection;

public class SQL3update {

  @SneakyThrows
  public static void main(String[] args) {
    Connection connection = Conn.make();
    DAO<Student> dao = new DAOStudentSQL(connection);

    dao.update(new Student(5, "JACK", 133));
  }
}
