package sql;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DAOMessages implements DAO<Messages>{
    private final Connection connection;

    public DAOMessages(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    @Override
    public void save (Messages message) {
        PreparedStatement st = connection.prepareStatement(
                """
                  INSERT INTO messages (sender, senderName, receiver, message, date) 
                  values (?, ?, ?, ?, ?)
                  """
        );
        st.setInt(1, message.getSender());
        st.setString(2, message.getSenderName());
        st.setInt(3, message.getReceiver());
        st.setString(4, message.getMessage());
        st.setTimestamp(5, Timestamp.valueOf(message.getDate()));
        st.execute();
    }

    @SneakyThrows
    @Override
    public List<Messages> showAll () {
        PreparedStatement st = connection.prepareStatement(
                """
                SELECT sender, senderName, receiver, message, date
                FROM messages
                """
        );
        ResultSet rs = st.executeQuery();
        List<Messages> messages = new ArrayList<>();
        while (rs.next()) {
            messages.add(Messages.fromResultSet(rs));
        }
        return messages;
    }
}
