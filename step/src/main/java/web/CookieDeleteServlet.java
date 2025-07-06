package web;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CookieDeleteServlet extends HttpServlet {

    private final LoggedIn loggedIn;

    public CookieDeleteServlet(LoggedIn loggedIn) {
        this.loggedIn = loggedIn;
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> maybeCookie = Auth.getCookieValue(req);
        maybeCookie.ifPresent(cookieValue -> {
            try {
                loggedIn.logout(cookieValue);
            } catch (IOException e) {
                throw new RuntimeException(e); // Либо обработать по-другому
            }
        });

        Cookie c = new Cookie("UID", "");
        c.setMaxAge(0); // seconds
//    c.setDomain("");
//    c.setPath("");

        resp.addCookie(c);
        System.out.println("Logout successful");
    }
}
