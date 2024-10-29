package lesson17;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

interface DAO<A extends HasId> {

  default void save(A a) throws IOException {
    throw new IllegalArgumentException("TODO");
  }
  default void update(A a) throws IOException {
    throw new IllegalArgumentException("TODO");
  }
  default void delete(A a) throws IOException {
    delete(a.id());
  }
  default void delete(Long id) throws IOException {
    throw new IllegalArgumentException("TODO");
  }
  default Optional<A> load(Long id) throws IOException, ClassNotFoundException{
    throw new IllegalArgumentException("TODO");
  }

  void save(List<A> xs) throws IOException;
  List<A> loadAll() throws IOException, ClassNotFoundException;

}
