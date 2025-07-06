package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import sql.*;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Connection conn = Conn.make("jdbc:postgresql://localhost:5432/fs10");
        DAOProfiles profiles = new DAOProfiles(conn);
        ProfilesService profilesService = new ProfilesService(conn, profiles);
        DAOMessages messages = new DAOMessages(conn);
        CreateProfileDatabase createProfileDatabase = new CreateProfileDatabase(conn, profiles);
        CreateCookiesDatabase createCookiesDatabase = new CreateCookiesDatabase();
        CreateMessagesDatabase createMessagesDatabase = new CreateMessagesDatabase(conn);
        LoggedIn loggedIn = new LoggedIn();
        createProfileDatabase.deleteDataBase(conn);
        createProfileDatabase.createProfiles(conn);
        createCookiesDatabase.deleteDataBase(conn);
        createCookiesDatabase.createDataBase(conn);
        createMessagesDatabase.deleteDatabase();
        createMessagesDatabase.createDatabase();

        TemplateEngine te = new TemplateEngine("tpl");

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/hello");
        handler.addServlet(new ServletHolder(new UsersServlet(te, loggedIn)), "/users");
        handler.addServlet(new ServletHolder(new LikedServlet(te)), "/liked");
        handler.addServlet(new ServletHolder(new LoginServlet(te, loggedIn, profilesService)), "/login");
        handler.addServlet(new ServletHolder(new CookieDeleteServlet(loggedIn)), "/logout");
        handler.addServlet(new ServletHolder(new MessagesServlet(te, conn, messages, profilesService)), "/messages");


        var ds = EnumSet.of(DispatcherType.REQUEST);
        var filter = new CookieFilter(
                rq -> Auth.getCookie(rq).isPresent(),
                rs -> rs.sendRedirect("/login")
        );
        handler.addFilter(new FilterHolder(filter), "/users", ds);
        handler.addFilter(new FilterHolder(filter), "/liked", ds);
        handler.addFilter(new FilterHolder(filter), "/messages", ds);

        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
