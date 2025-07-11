package sql;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    @SneakyThrows
    public static Connection make(String url) {
        String username = "postgres";
        String password = "postgres";

        return DriverManager.getConnection(url, username, password);
    }

    @SneakyThrows
    public static Connection make() {
        String url = "jdbc:postgresql://localhost:5432/fs10";
        String username = "postgres";
        String password = "postgres";

        return DriverManager.getConnection(url, username, password);
    }

}