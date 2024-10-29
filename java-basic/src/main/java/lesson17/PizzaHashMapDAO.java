package lesson17;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PizzaHashMapDAO implements PizzaDAO {

  private final Map<Long, Pizza> storage = new HashMap<>();

  @Override
  public void save(List<Pizza> xs) throws IOException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<Pizza> loadAll() throws IOException, ClassNotFoundException {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
