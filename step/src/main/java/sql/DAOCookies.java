package sql;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOCookies implements DAO<Cookies> {
    public final Connection connection;

    public DAOCookies(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    @Override
    public List<Cookies> showAll() {
        PreparedStatement st = connection.prepareStatement(
                """
                SELECT cookieValue, userId 
                FROM cookies
                """
        );
        ResultSet rs = st.executeQuery();
        List<Cookies> cookies = new ArrayList<>();
        while (rs.next()) cookies.add(Cookies.fromResultSet(rs));
        return cookies;
    };

    @SneakyThrows
    @Override
    public void update(Cookies cookie) throws IOException{
        PreparedStatement st = connection.prepareStatement(
                """
                UPDATE cookies
                SET cookieValue = ?
                WHERE userId = ?
                """
        );
        st.setString(1, cookie.getCookieValue());
        st.setInt(2, cookie.getUserId());
        st.execute();
    }

    @SneakyThrows
    @Override
    public void save(Cookies cookie) throws IOException {
        PreparedStatement st = connection.prepareStatement(
                """
                  INSERT INTO cookies (cookieValue, userId) values (?, ?)
                  """
        );
            st.setString(1, cookie.getCookieValue());
            st.setInt(2, cookie.getUserId());
            st.execute();
    }

    @SneakyThrows
    @Override

    public void delete(Cookies cookie) throws IOException {
        PreparedStatement st = connection.prepareStatement(
                """
                  DELETE FROM cookies
                      WHERE id = ?
                  """
        );
        st.setInt(1, cookie.getUserId());
        int i = st.executeUpdate();
    }

}

