package web;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Messages {
    private String sender;
    private String receiver;
    private String message;
    private LocalDateTime date;

    public Messages(String sender, String receiver, String message, LocalDateTime date) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = date;
    }
    public String getSender() {
        return sender;
    }
    public String getReceiver() {
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
        String sender = rs.getString("sender");
        String receiver = rs.getString("receiver");
        String message = rs.getString("message");
        LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
        return new Messages(sender, receiver, message, date);
    }
}
