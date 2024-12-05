package web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

interface HttpFilter extends Filter {
  @Override
  default void init(FilterConfig filterConfig) {}

  default boolean isHttp(ServletRequest rq0, ServletResponse rs0) {
    return rq0 instanceof HttpServletRequest && rs0 instanceof HttpServletResponse;
  }

  boolean checkLogic(HttpServletRequest rq);

  void ifNotPassed(HttpServletResponse rs) throws IOException;

  @Override
  default void doFilter(ServletRequest rq0, ServletResponse rs0, FilterChain chain) throws IOException, ServletException {
    if (!isHttp(rq0, rs0)) {
      chain.doFilter(rq0, rs0);
    } else {
      HttpServletRequest rq = (HttpServletRequest) rq0;
      HttpServletResponse rs = (HttpServletResponse) rs0;

      if (checkLogic(rq)) {
        // OK
        chain.doFilter(rq0, rs0);
      } else {
        // ERROR
        ifNotPassed(rs);
      }
    }
  }

  @Override
  default void destroy() {}
}
