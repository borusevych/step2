package web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyCookieFilter0 implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  boolean isHttp(ServletRequest rq0, ServletResponse rs0) {
    return rq0 instanceof HttpServletRequest && rs0 instanceof HttpServletResponse;
  }

  @Override
  public void doFilter(ServletRequest rq0, ServletResponse rs0, FilterChain chain) throws IOException, ServletException {
    if (!isHttp(rq0, rs0)) {
      chain.doFilter(rq0, rs0);
    } else {
      HttpServletRequest rq = (HttpServletRequest) rq0;
      HttpServletResponse rs = (HttpServletResponse) rs0;

      if (Auth.getCookie(rq).isPresent()) {
        // OK
        chain.doFilter(rq0, rs0);
      } else {
        // ERROR
        rs.sendRedirect("/login");
      }
    }
  }

  @Override
  public void destroy() {
  }
}
