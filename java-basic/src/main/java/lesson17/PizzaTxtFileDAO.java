package lesson17;

import java.io.*;
import java.util.List;
import java.util.Optional;

public class PizzaTxtFileDAO implements PizzaDAO {

  private final String fileName;

  public PizzaTxtFileDAO(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void update(Pizza pizza) throws IOException {
    List<Pizza> modified = loadAll().stream()
      .map(p -> p.id == pizza.id ? pizza : p)
      .toList();
    save(modified);
  }

  @Override
  public void delete(Long id) throws IOException {
    List<Pizza> withoutId = loadAll().stream()
      .filter(p -> p.id != id)
      .toList();
    save(withoutId);
  }

  @Override
  public Optional<Pizza> load(Long id) throws IOException, ClassNotFoundException {
    try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
      return r.lines()
        .map(Pizza::fromString)
        .filter(p -> p.id == id)
        .findFirst();
    }
  }

  @Override
  public void save(Pizza pizza) throws IOException {
    List<Pizza> pizzas = loadAll();
    pizzas.addLast(pizza);
    save(pizzas);
  }

  @Override
  public void save(List<Pizza> xs) throws IOException {
    try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(fileName)))) {
      for (Pizza p : xs) {
        w.write(p.represent());
        w.newLine();
      }
    }
  }

  @Override
  public List<Pizza> loadAll() throws IOException {
    try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
      return r.lines()
        .map(Pizza::fromString)
        .toList();
    }
  }


}
