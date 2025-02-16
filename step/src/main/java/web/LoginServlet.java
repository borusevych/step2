package web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

  private final UsersDatabase db;
  private final LoggedIn loggedIn;
  private final TemplateEngine te;

  public LoginServlet(UsersDatabase db, LoggedIn loggedIn, TemplateEngine te) {
    this.db = db;
    this.loggedIn = loggedIn;
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    te.render("login_form.html", resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    Optional<String> maybeUser = db.login(username, password);
    try(PrintWriter w = resp.getWriter()) {
      if (maybeUser.isEmpty()) {
        w.write("login + password don't match");
      } else {
        String user = maybeUser.get(); // jim
        String cookieValue = loggedIn.login(user); // 4353465056-456456-54654646
        Cookie c = new Cookie("UID", cookieValue);
        resp.addCookie(c);
        w.write(String.format("user %s auth successfully", user));
      }
    }
  }
}
