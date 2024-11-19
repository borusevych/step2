package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    History history = new InMemoryHistory();

    TemplateEngine te = new TemplateEngine("tpl");

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/hello");
    handler.addServlet(new ServletHolder(new TemplateServlet(te)), "/t");

    CalcService calcService = new CalcService();

    CalculatorServlet calculatorServlet = new CalculatorServlet(calcService, history);
    handler.addServlet(new ServletHolder(calculatorServlet), "/calc");

    CalcFormServlet calculatorServlet2 = new CalcFormServlet(calcService, history, te);
    handler.addServlet(new ServletHolder(calculatorServlet2), "/calc_form");

    HistoryServlet historyServlet = new HistoryServlet(history, te);
    handler.addServlet(new ServletHolder(historyServlet), "/history");

    HomeServlet homeServlet = new HomeServlet(te);
    handler.addServlet(new ServletHolder(homeServlet), "/home");

    handler.addServlet(new ServletHolder(new StaticContentServlet("static0")), "/static/*");

    handler.addServlet(new ServletHolder(new RedirectServlet("/home")), "/*");

    server.setHandler(handler);

    server.start();
    server.join();
  }

}
