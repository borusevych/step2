package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class CookieGetServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Auth.getCookie(req)
      .ifPresent(cookie ->
        System.out.println(cookie.getName() + ":" + cookie.getValue())
      );

    Enumeration<String> headers = req.getHeaderNames();
    while (headers.hasMoreElements()) {
      String n = headers.nextElement();
      System.out.printf("%s -> %s\n", n, req.getHeader(n));
    }


  }

}
