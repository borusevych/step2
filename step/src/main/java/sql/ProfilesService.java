package sql;

import lombok.SneakyThrows;
import web.Auth;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ProfilesService{
    public final Connection connection;
    private DAO<Profiles> dao;

    public ProfilesService(Connection connection, DAO<Profiles> dao) {
        this.connection = connection;
        this.dao = dao;
    }
    @SneakyThrows
    public void saveAll(List<Profiles> profiles) throws IOException {
        dao.saveAll(profiles);
    }

    @SneakyThrows
    public List<Profiles> showAll() throws IOException {
        return dao.showAll();
    }

    @SneakyThrows
    public void update(Profiles profile) throws IOException{
        dao.update(profile);
    }

    @SneakyThrows
    public Optional<Integer> login(String name, String password) {
        return dao.showAll().stream()
                .filter(profile -> profile.getPassword().equals(password) && profile.getName().equals(name))
                .findFirst()
                .map(Profiles::getId);
    }

    @SneakyThrows
    public Optional<Profiles> whoIsLoggedIn(HttpServletRequest req, Connection connection) {
        String cookieReq = Auth.getCookieValue(req).orElse("");
        if (cookieReq.isEmpty()) {
            return Optional.empty();
        }
        DAOCookies daoCookies = new DAOCookies(connection);
        Optional<Integer> userId = daoCookies.showAll().stream()
                .filter(cookie -> cookie.getCookieValue().equals(cookieReq))
                .map(Cookies::getUserId)
                .findFirst();
        if (userId.isEmpty()) {
            return Optional.empty();
        }
        return dao.showAll().stream()
                .filter(profile -> profile.getId() == userId.get()) // Получаем значение из Optional
                .findFirst();
    }

}



