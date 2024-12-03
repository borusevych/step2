package web;

import java.time.LocalDateTime;

public class Item {

  String line;
  LocalDateTime time;
  String who;

  public Item(String line, String who, LocalDateTime time) {
    this.line = line;
    this.who = who;
    this.time = time;
  }

  public Item(String line, String who) {
    this(line, who, LocalDateTime.now());
  }

  public Item(String line, LocalDateTime time) {
    this(line, "unknown", time);
  }

  public Item(String line) {
    this(line, LocalDateTime.now());
  }

  @Override
  public String toString() {
    return "%s at %s".formatted(line, time);
  }

  public String getLine() {
    return line;
  }

  public String getWho() {
    return who == null ? "<null>" : who;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
