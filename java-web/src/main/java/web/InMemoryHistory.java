package web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryHistory implements History {

  private final List<Item> data = new ArrayList<>();

  @Override
  public void store(Item item) {
    data.add(item);
  }

  @Override
  public List<Item> getAll() {
    return Collections.unmodifiableList(data);
  }

  @Override
  public List<Item> getBy(String username) {
    return data.stream().filter(x -> x.getWho().equals(username)).toList();
  }

}
