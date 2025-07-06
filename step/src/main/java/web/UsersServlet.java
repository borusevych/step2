package web;

import sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;

public class UsersServlet extends HttpServlet {
    private final TemplateEngine te;
    private final LoggedIn loggedIn;
    private Connection connection = Conn.make();
    private DAO<Profiles> DAOProfiles = new DAOProfiles(connection);
    private ProfilesService profilesService = new ProfilesService(connection, DAOProfiles);
    private DAO<Cookies> DAOCookies = new DAOCookies(connection);
    private CookiesService cookiesService = new CookiesService(connection, DAOCookies);

    public UsersServlet(TemplateEngine te, LoggedIn loggedIn) {
        this.te = te;
        this.loggedIn = loggedIn;
    }
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String indexParam = req.getParameter("currentIndex");
    int currentUserIndex = (indexParam != null) ? Integer.parseInt(indexParam) : 0;

    Profiles loggedUser = profilesService.whoIsLoggedIn(req, connection).get();
    List<Profiles> profilesFromDAO = profilesService.showAll();
    List<Profiles> selectedProfiles = profilesFromDAO.stream()
            .filter(profile -> profile.getId() != loggedUser.getId())
            .collect(Collectors.toList());

    Profiles currentUser = selectedProfiles.get(currentUserIndex);
    String name = currentUser.getName();
    String imageUrl = currentUser.getImg();

    HashMap<String, Object> data = new HashMap<>();
    data.put("name", name);
    data.put("img", imageUrl);
    data.put("currentIndex", currentUserIndex);

    te.render("users.html", data, resp);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userResponse = req.getParameter("response");
        String indexParam = req.getParameter("currentIndex");
        Profiles loggedUser = profilesService.whoIsLoggedIn(req, connection).get();
        List<Profiles> profilesFromDAO = profilesService.showAll();
        List<Profiles> selectedProfiles = profilesFromDAO.stream()
                .filter(profile -> profile.getId() != loggedUser.getId())
                .collect(Collectors.toList());

        int currentUserIndex = (indexParam != null) ? Integer.parseInt(indexParam) : 0;
        if(userResponse.equals("yes")){
            int likedUser = selectedProfiles.get(currentUserIndex).getId();
            loggedUser.setLiked(likedUser);
            profilesService.update(loggedUser);
        }
//        if(userResponse.equals("no")){
//            int likedUser = selectedProfiles.get(currentUserIndex).getId();
//            loggedUser.setDisLiked(likedUser);
//            profilesService.update(loggedUser);
//        }
        currentUserIndex++;
        if (currentUserIndex >= selectedProfiles.size()) {
            currentUserIndex = 0;
            resp.sendRedirect("/liked");
        } else {
            resp.sendRedirect("users?currentIndex=" + currentUserIndex);
        }

    }
}

