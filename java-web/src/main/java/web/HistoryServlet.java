package web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class HistoryServlet extends HttpServlet {

  private final History history;
  private final TemplateEngine te;
  private final LoggedIn loggedIn;

  public HistoryServlet(History history, TemplateEngine te, LoggedIn loggedIn) {
    this.history = history;
    this.te = te;
    this.loggedIn = loggedIn;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Optional<String> maybeCookie = Optional.ofNullable(req.getCookies())
      .stream()
      .flatMap(Arrays::stream)
      .filter(c -> c.getName().equals("UID"))
      .findFirst()
      .map(Cookie::getValue);

    List<Item> items = new ArrayList<>();

    maybeCookie.flatMap(loggedIn::check)
      .ifPresentOrElse(
        u -> items.addAll(history.getBy(u)),
        () -> items.addAll(history.getAll())
      );

    HashMap<String, Object> data = new HashMap<>();
    data.put("items", items);
    te.render("history.ftl", data, resp);
  }
}
