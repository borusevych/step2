package web;

import sql.*;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class LoggedIn {

    private DAOCookies daoCookies = new DAOCookies(Conn.make());
    private CookiesService service = new CookiesService(Conn.make(), daoCookies);
    private CreateCookiesDatabase createCookiesDatabase = new CreateCookiesDatabase();

    public String login(int userId) throws IOException {
        String id = UUID.randomUUID().toString();
        Cookies cookie = new Cookies(id, userId);
        service.save(cookie);
        return id;
    }

    public void logout(String cookieValue) throws IOException {
        Optional<Cookies> theCookie = service.findByCookie(cookieValue);
        if (theCookie.isPresent()) {
            Cookies cookie = theCookie.get();
            service.delete(cookie);
            //createCookiesDatabase.deleteDataBase(Conn.make());
        }
    }

}
