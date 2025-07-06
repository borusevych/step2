package sql;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Messages {
    private int sender;
    private String senderName;
    private int receiver;
    private String message;
    private LocalDateTime date;

    public Messages(int sender, String senderName, int receiver, String message, LocalDateTime date) {
        this.sender = sender;
        this.senderName = senderName;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
    }
    public int getSender() {
        return sender;
    }
    public String getSenderName() {
        return senderName;
    }
    public int getReceiver() {
        return receiver;
    }
    public String getMessage() {
        return message;
    }
    public LocalDateTime getDate() {
        return date;
    }
    @SneakyThrows
    public static Messages fromResultSet(ResultSet rs){
        int sender = rs.getInt("sender");
        String senderName = rs.getString("senderName");
        int receiver = rs.getInt("receiver");
        String message = rs.getString("message");
        LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
        return new Messages(sender, senderName, receiver, message, date);
    }

    @Override
    public String toString() {
        return "Message [sender=" + senderName + ", receiver=" + receiver + ", message=" + message + ", date=" + date + "]";
    }
}
