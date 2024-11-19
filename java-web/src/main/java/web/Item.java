package web;

import java.time.LocalDateTime;

public class Item {

  String line;
  LocalDateTime time;

  public Item(String line) {
    this.line = line;
    this.time = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "%s at %s".formatted(line, time);
  }

  public String getLine() {
    return line;
  }

  public LocalDateTime getTime() {
    return time;
  }
}
