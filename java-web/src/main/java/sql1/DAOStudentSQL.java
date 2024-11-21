package sql1;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOStudentSQL implements DAO<Student>{

  private final Connection connection;

  public DAOStudentSQL(Connection connection) {
    this.connection = connection;
  }

  @SneakyThrows
  @Override
  public void update(Student student) throws IOException {
    PreparedStatement st = connection.prepareStatement(
      """
        UPDATE student
           SET name = ?, dob = ?
         WHERE id = ?
        """
    );
    st.setString(1, student.name());
    st.setInt(2, student.age());
    st.setInt(3, student.id());
    st.execute();
  }

  @SneakyThrows
  @Override
  public void delete(int id) throws IOException {
    PreparedStatement st = connection.prepareStatement(
      """
        DELETE FROM student
            WHERE id = ?
        """
    );
    st.setInt(1, id);
    int i = st.executeUpdate(); // 1 record modified
  }

  @SneakyThrows
  @Override
  public Optional<Student> load(int id) throws IOException {
    PreparedStatement st = connection.prepareStatement(
      """
        SELECT id, name, dob
        FROM student
        WHERE id = ?
        """
    );
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();

    return rs.next() ?
      Optional.of(Student.fromResultSet(rs)) : Optional.empty();
  }

  @SneakyThrows
  @Override
  public void save(List<Student> xs) throws IOException {
    PreparedStatement st = connection.prepareStatement(
      """
        INSERT INTO student (name, dob) values (?, ?)
        """
    );
    for (Student x : xs) {
      st.setString(1, x.name());
      st.setInt(2, x.age());
      st.execute();
    }
  }

  @SneakyThrows
  @Override
  public List<Student> loadAll() {
    PreparedStatement st = connection.prepareStatement(
      """
        SELECT id, name, dob
        FROM student
        """
    );
    ResultSet rs = st.executeQuery();
    List<Student> xs = new ArrayList<>();
    while (rs.next()) xs.add(Student.fromResultSet(rs));
    return xs;
  }
}
