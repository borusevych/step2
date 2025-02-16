package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Function;

public class MyCookieFilter2 implements HttpFilter {

  private final Function<HttpServletRequest, Boolean> logic;
  private final ConsumerEx<HttpServletResponse> whenWrong;

  public MyCookieFilter2(Function<HttpServletRequest, Boolean> logic, ConsumerEx<HttpServletResponse> whenWrong) {
    this.logic = logic;
    this.whenWrong = whenWrong;
  }

  @Override
  public boolean checkLogic(HttpServletRequest rq) {
    return logic.apply(rq);
  }

  @Override
  public void ifNotPassed(HttpServletResponse rs) throws IOException {
    whenWrong.accept(rs);
  }
}
