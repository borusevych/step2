package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyCookieFilter1 implements HttpFilter{
  @Override
  public boolean checkLogic(HttpServletRequest rq) {
    return Auth.getCookie(rq).isPresent();
  }

  @Override
  public void ifNotPassed(HttpServletResponse rs) throws IOException {
    rs.sendRedirect("/login");
  }

}
