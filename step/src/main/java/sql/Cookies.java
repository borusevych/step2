package sql;

import lombok.SneakyThrows;

import java.sql.ResultSet;

public class Cookies {
    private String cookieValue;
    private int userId;
    public Cookies(String _cookieValue, int _userId) {
        cookieValue = _cookieValue;
        userId = _userId;
    }
    public String getCookieValue() {
        return cookieValue;
    }
    public int getUserId() {
        return userId;
    }
    public void setCookieValue(String _cookieValue) {
        cookieValue = _cookieValue;
    }
    @SneakyThrows
    public static Cookies fromResultSet(ResultSet rs) {
        String cookieValue = rs.getString("cookieValue");
        int userId = rs.getInt("userId");
        return new Cookies(cookieValue, userId);
    }
    @Override
    public String toString() {
        return "Cookie [cookieValue=" + this.getCookieValue() + ", userId=" + this.getUserId() + "]";
    }
}
