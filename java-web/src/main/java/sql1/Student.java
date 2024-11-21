package sql1;

import lombok.SneakyThrows;

import java.sql.ResultSet;

public record Student(Integer id, String name, int age) implements HasId {

  @SneakyThrows
  static Student fromResultSet(ResultSet rs) {
    int id = rs.getInt("id");
    String name = rs.getString("name");
    int dob = rs.getInt("dob");
    return new Student(id, name, dob);
  }

}