package sql1;

import lombok.SneakyThrows;

import java.sql.Connection;

public class SQL4delete {

  @SneakyThrows
  public static void main(String[] args) {
    Connection connection = Conn.make();
    DAO<Student> dao = new DAOStudentSQL(connection);

    dao.delete(6);
  }
}
