package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class HistoryServlet extends HttpServlet {

  private final History history;
  private final TemplateEngine te;

  public HistoryServlet(History history, TemplateEngine te) {
    this.history = history;
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    data.put("items", history.getAll());
    te.render("history.ftl", data, resp);
  }
}
