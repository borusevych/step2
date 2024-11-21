package sql1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQL0App {

  public static void main(String[] args) throws SQLException {

    Connection connection = Conn.make();
//    String sql = "SELECT id, name, dob from student";
//    String sql = "SELECT id, name, dob from student where dob = 1973";

    String jsonOld = "{\"id\": 1,\"name\":\"Jim\",\"age\": 25}";
    String jsonNew = """
      {
        "id": 1,
        "name":"Jim",
        "age": 25
      }
      """;

    String sql = """
        SELECT id, name, dob
        FROM student
        WHERE dob = ?
        """;

    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setInt(1, 1973);

    ResultSet rs = stmt.executeQuery();
    ArrayList<Student> xs = new ArrayList<>();
    while (rs.next()) {
      xs.add(Student.fromResultSet(rs));
    }

    xs.forEach(System.out::println);


  }

}
