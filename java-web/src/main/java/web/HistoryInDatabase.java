package web;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryInDatabase implements History {

  private final Connection connection;

  private static final String sql_create_db = """
      CREATE TABLE IF NOT EXISTS history (
          id SERIAL PRIMARY KEY,
          line text,
          at TIMESTAMP
      )
    """;

  private static final String sql_insert =
    "INSERT INTO history (line, at) values (?, ?)";

  private static final String sql_select =
    "SELECT line, at FROM history order by id";

  @SneakyThrows
  public HistoryInDatabase(Connection connection) {
    this.connection = connection;
    PreparedStatement st = connection.prepareStatement(sql_create_db);
    st.execute();
  }

  @SneakyThrows
  @Override
  public void store(Item item) {
    PreparedStatement st = connection.prepareStatement(sql_insert);
    st.setString(1, item.getLine());
    st.setObject(2, item.getTime());
    st.execute();
  }

  @SneakyThrows
  @Override
  public List<Item> getAll() {
    PreparedStatement st = connection.prepareStatement(sql_select);
    ResultSet rs = st.executeQuery();
    var xs = new ArrayList<Item>();
    while (rs.next()) {
      xs.add(new Item(
        rs.getString("line"),
        rs.getObject("at", LocalDateTime.class)
      ));
    }
    return xs;
  }
}
