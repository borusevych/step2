package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class CalculatorServlet extends HttpServlet {

  private final CalcService calcService;
  private final History history;

  public CalculatorServlet(CalcService calcService, History history) {
    this.calcService = calcService;
    this.history = history;
  }

  @Override
  protected void doGet(
    HttpServletRequest rq,
    HttpServletResponse rs) throws ServletException, IOException {

    String outcome = calcService.doCalc(
      Optional.ofNullable(rq.getParameter("x")), // can be null
      Optional.ofNullable(rq.getParameter("y")),
      Optional.ofNullable(rq.getParameter("op"))
    );
    history.store(new Item(outcome));

    try (PrintWriter w = rs.getWriter()) {
      w.println(outcome);
    }
  }
}
