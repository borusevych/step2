package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Function;

public record MyCookieFilter3(
  Function<HttpServletRequest, Boolean> logic,
  ConsumerEx<HttpServletResponse> whenWrong
) implements HttpFilter {

  @Override
  public boolean checkLogic(HttpServletRequest rq) {
    return logic.apply(rq);
  }

  @Override
  public void ifNotPassed(HttpServletResponse rs) throws IOException {
    whenWrong.accept(rs);
  }
}
