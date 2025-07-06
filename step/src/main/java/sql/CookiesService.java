package sql;

import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class CookiesService {
    public final Connection connection;
    private DAO<Cookies> dao;

    public CookiesService(Connection connection, DAO<Cookies> dao) {
        this.connection = connection;
        this.dao = dao;
    }

    @SneakyThrows
    public List<Cookies> showAll() {
        return dao.showAll();
    }

    @SneakyThrows
    public void update(Cookies cookie) throws IOException {
        dao.update(cookie);
    }

    @SneakyThrows
    public void save(Cookies cookie) throws IOException {
        dao.save(cookie);
    }

    @SneakyThrows
    public void delete(Cookies cookie) throws IOException {
        dao.delete(cookie);
    }

    @SneakyThrows
    public Optional<Cookies> findByCookie(String cookieValue) {
        return dao.showAll().stream()
                .filter(cookie -> cookieValue == cookie.getCookieValue())
                .findFirst();
    }
}
