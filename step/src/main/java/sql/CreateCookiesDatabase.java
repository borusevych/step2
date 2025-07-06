package sql;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class CreateCookiesDatabase {

    private static final String sql_delete =
            "DROP TABLE IF EXISTS cookies;";

    private static final String sql_create_db = """
              CREATE TABLE IF NOT EXISTS cookies (
                  cookieValue text,
                  userId int
              )
            """;
//SERIAL PRIMARY KEY
    @SneakyThrows
    public void createDataBase(Connection connection) {
        PreparedStatement st = connection.prepareStatement(sql_create_db);
        st.execute();
    }

    @SneakyThrows
    public void deleteDataBase(Connection connection) {
        PreparedStatement st = connection.prepareStatement(sql_delete);
        st.execute();
    }
}
