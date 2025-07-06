package sql;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateMessagesDatabase {
    private Connection connection;

    public CreateMessagesDatabase(Connection _connection) {
        connection = _connection;
    }

    private static final String sql_delete =
            "DROP TABLE IF EXISTS messages;";

    private static final String sql_create_db = """
              CREATE TABLE IF NOT EXISTS messages (
                  sender int,
                  senderName text,
                  receiver int,
                  message text,
                  date TIMESTAMP
              )
            """;

    @SneakyThrows
    public void createDatabase() {
        PreparedStatement st = connection.prepareStatement(sql_create_db);
        st.execute();
    }

    @SneakyThrows
    public void deleteDatabase() {
        PreparedStatement st = connection.prepareStatement(sql_delete);
        st.execute();
    }

}
