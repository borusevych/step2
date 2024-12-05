package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sql1.Conn;

import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import java.sql.Connection;
import java.util.EnumSet;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    // structure analysis
    DatabaseStructure.migrate(
      "jdbc:postgresql://localhost:5432/fs10",
      "postgres", "pg123456"
    );
    // now we 100% guarantee that structure is the most recent.

    Connection conn = Conn.make("jdbc:postgresql://localhost:5432/fs10");
    History history =
//      new InMemoryHistory();
//    new HistoryInDatabase(sql1.Conn.make(System.getenv("DB_URL")));
      new HistoryInDatabase(conn);
    var loggedIn = new LoggedIn();
    TemplateEngine te = new TemplateEngine("tpl");
    UsersDatabase usersDb = new UsersDatabase();
    CalcService calcService = new CalcService();

    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(HelloServlet.class, "/hello");
    handler.addServlet(new ServletHolder(new TemplateServlet(te)), "/t");
    CalculatorServlet calculatorServlet = new CalculatorServlet(calcService, history);
    handler.addServlet(new ServletHolder(calculatorServlet), "/calc");
    CalcFormServlet calculatorServlet2 = new CalcFormServlet(calcService, history, te, loggedIn);
    handler.addServlet(new ServletHolder(calculatorServlet2), "/calc_form");
    HistoryServlet historyServlet = new HistoryServlet(history, te, loggedIn);
    handler.addServlet(new ServletHolder(historyServlet), "/history");
    HomeServlet homeServlet = new HomeServlet(te);
    handler.addServlet(new ServletHolder(homeServlet), "/home");
    handler.addServlet(new ServletHolder(new StaticContentServlet("static0")), "/static/*");
    handler.addServlet(CookieGetServlet.class, "/cg");
    handler.addServlet(CookieSetServlet.class, "/cs");
    handler.addServlet(new ServletHolder(new CookieDeleteServlet(loggedIn)), "/logout");
    handler.addServlet(CookieIdentifyServlet.class, "/id");
    handler.addServlet(new ServletHolder(new LoginServlet(usersDb, loggedIn, te)), "/login");

    ServletHolder sh = new ServletHolder(new UploadServlet(te));
    sh.getRegistration().setMultipartConfig(new MultipartConfigElement("./buffer")); // tmp file
    handler.addServlet(sh, "/up");
    handler.addServlet(new ServletHolder(new RedirectServlet("/home")), "/*");

    var ds = EnumSet.of(DispatcherType.REQUEST);
//    handler.addFilter(MyCookieFilter1.class, "/id", ds);
    var filter = new MyCookieFilter3(
      rq -> Auth.getCookie(rq).isPresent(),
      rs -> rs.sendRedirect("/login")
    );
    handler.addFilter(new FilterHolder(filter), "/id", ds);

    Server server = new Server(8080);
    server.setHandler(handler);

    server.start();
    server.join();
  }

}
