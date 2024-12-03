package web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

public class CookieIdentifyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Optional<String> maybeCookie = Optional.ofNullable(req.getCookies())
      .stream()
      .flatMap(Arrays::stream)
      .filter(c -> c.getName().equals("UID"))
      .findFirst()
      .map(Cookie::getValue);

    try(PrintWriter w = resp.getWriter()) {
      String msg;

      if (maybeCookie.isPresent()) {
        String id = maybeCookie.get();
        msg = String.format("you have been identified: %s", id);
      } else {
        msg = "You have not identified, identifying...";
        String id = UUID.randomUUID().toString();
        Cookie c = new Cookie("UID", id);
        resp.addCookie(c);
      }
      w.write(msg);
    }
  }

}
