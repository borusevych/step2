package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class TemplateServlet extends HttpServlet {

  private final TemplateEngine te;

  public TemplateServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    data.put("name", "Jim");

    te.render("hello.html", data, resp);
  }

}
