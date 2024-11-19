package web;

import java.util.List;

public interface History {

  void store(Item item);

  List<Item> getAll();

}
