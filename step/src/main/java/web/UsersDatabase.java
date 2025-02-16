package web;

import java.util.Map;
import java.util.Optional;

public class UsersDatabase {

  record LoginDetails(String username, String password) {}

  private final Map<LoginDetails, String> data = Map.of(
    new LoginDetails("jim", "123"), "jim",
    new LoginDetails("alex", "123456"), "alex",
    new LoginDetails("jack", "234"), "jack"
  );

  public Optional<String> login(String username, String password) {
    LoginDetails ld = new LoginDetails(username, password);
    return Optional.ofNullable(data.get(ld));
  }

  public static void main(String[] args) {
    UsersDatabase a = new UsersDatabase();
    Optional<String> a1 = a.login("jim", "123"); // Optional[jim]
    System.out.println(a1);
    Optional<String> a2 = a.login("jim", "12345"); // Optional.empty
    System.out.println(a2);
  }

}
