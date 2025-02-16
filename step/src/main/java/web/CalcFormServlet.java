package web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class CalcFormServlet extends HttpServlet {

  private final CalcService calcService;
  private final History history;
  private final TemplateEngine te;
  private final LoggedIn loggedIn;

  public CalcFormServlet(CalcService calcService, History history, TemplateEngine te, LoggedIn loggedIn) {
    this.calcService = calcService;
    this.history = history;
    this.te = te;
    this.loggedIn = loggedIn;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    te.render("calc_form.html", resp);
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String outcome = calcService.doCalc(
      Optional.ofNullable(rq.getParameter("x")), // can be null
      Optional.ofNullable(rq.getParameter("y")),
      Optional.ofNullable(rq.getParameter("op"))
    );
    Optional<String> maybeCookie = Optional.ofNullable(rq.getCookies())
      .stream()
      .flatMap(Arrays::stream)
      .filter(c -> c.getName().equals("UID"))
      .findFirst()
      .map(Cookie::getValue);

    String user = maybeCookie.flatMap(loggedIn::check).orElse("<< unknown >>");

    history.store(new Item(outcome, user));
    HashMap<String, Object> data = new HashMap<>();
    data.put("result", outcome);

    te.render("calc_result.ftl", data, rs);
  }
}
