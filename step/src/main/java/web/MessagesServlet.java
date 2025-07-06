package web;

import sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MessagesServlet extends HttpServlet {
    private TemplateEngine te;
    private Connection connection;
    private final DAOMessages DAOMessages;
    private final ProfilesService profilesService;
    public MessagesServlet(TemplateEngine _te, Connection _connection, DAOMessages _daoMessages, ProfilesService _profilesService) {
        te = _te;
        connection = _connection;
        DAOMessages = _daoMessages;
        profilesService = _profilesService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userResponse = req.getParameter("id");
        int id = (userResponse != null && !userResponse.isEmpty()) ? Integer.parseInt(userResponse) : -1;
        if (id == -1) {
            try(PrintWriter out = resp.getWriter()) {
                out.print("First choose who you would like to chat with");
            }
        } else {
            List<Messages> messages = DAOMessages.showAll();
            System.out.println(messages.size());
            messages.forEach(message -> {
                System.out.println(message);
            });
            HashMap<String, Object> data = new HashMap<>();
            data.put("messages", messages);
            te.render("messages.ftl", data, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userResponse = req.getParameter("id");
        int receiver = Integer.parseInt(userResponse);
        Optional<Profiles> theSender = profilesService.whoIsLoggedIn(req, connection);
        int sender = theSender.get().getId();
        String senderName = theSender.get().getName();
        String messageUser = req.getParameter("message");
        Messages message = new Messages(sender, senderName, receiver, messageUser, LocalDateTime.now());
        DAOMessages.save(message);


        List<Messages> messages = DAOMessages.showAll();
        HashMap<String, Object> data = new HashMap<>();
        data.put("messages", messages);
        te.render("messages.ftl", data, resp);
    }
}
