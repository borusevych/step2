package web;

import sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class LikedServlet extends HttpServlet {
    private final TemplateEngine te;
    private Connection connection = Conn.make();
    private DAO<Profiles> DAOProfiles = new DAOProfiles(connection);
    private ProfilesService profilesService = new ProfilesService(connection, DAOProfiles);
    private DAO<Cookies> DAOCookies = new DAOCookies(connection);
    private CookiesService cookiesService = new CookiesService(connection, DAOCookies);

    public LikedServlet(TemplateEngine te) {
        this.te = te;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Profiles loggedUser = profilesService.whoIsLoggedIn(req, connection).get();
        List<Integer> likedIds= loggedUser.getLiked();
        List<Profiles> likedUsers = new ArrayList<>();
        likedIds.forEach(likedId -> {
            try {
                Optional<Profiles> likedProfile = DAOProfiles.showAll().stream()
                        .filter( profile -> profile.getId() == likedId)
                        .findFirst();
                likedUsers.add(likedProfile.get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        HashMap<String, Object> data = new HashMap<>();
        data.put("likedUsers", likedUsers);

        te.render("liked.ftl", data, resp);
    }
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userResponse = req.getParameter("response");
        int id = (userResponse != null && !userResponse.isEmpty()) ? Integer.parseInt(userResponse) : -1;
        resp.sendRedirect("/messages?id=" + id);
    }
}
