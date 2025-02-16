package web;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class LoggedIn {

  //                    cookie, userName
  // c737a22b-5252-43c3-87d5-e84ac43f2bac -> jim
  private final HashMap<String, String> data = new HashMap<>();

  public String login(String userName) {
    String id = UUID.randomUUID().toString();
    data.put(id, userName);
    return id;
  }

  public void logout(String cookieValue) {
    data.remove(cookieValue);
  }

  public Optional<String> check(String cookieValue) {
    return Optional.ofNullable(data.get(cookieValue));
  }

}
