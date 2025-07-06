package web;

import sql.ProfilesService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginServlet extends HttpServlet {
    private final TemplateEngine te;
    private LoggedIn loggedIn;
    private ProfilesService profilesService;

    public LoginServlet(TemplateEngine te, LoggedIn loggedIn, ProfilesService profilesService) {
        this.te = te;
        this.loggedIn = loggedIn;
        this.profilesService = profilesService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        te.render("login_form.html", resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Integer> maybeUser = profilesService.login(username, password);
        try(PrintWriter w = resp.getWriter()) {
            if (maybeUser.isEmpty()) {
                w.write("login + password don't match");
            } else {
                Integer user = maybeUser.get();
                String cookieValue = loggedIn.login(user);
                Cookie c = new Cookie("UID", cookieValue);
                resp.addCookie(c);
                w.write(String.format("user %s auth successfully", user));
            }
        }
    }
}
