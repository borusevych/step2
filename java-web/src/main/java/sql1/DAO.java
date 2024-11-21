package sql1;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

interface DAO<A extends HasId> {

  default void save(A a) throws IOException {
    save(List.of(a));
  }

  void update(A a) throws IOException;

  default void delete(A a) throws IOException {
    delete(a.id());
  }

  void delete(int id) throws IOException;

  Optional<A> load(int id) throws IOException;

  void save(List<A> xs) throws IOException;

  List<A> loadAll() throws IOException, ClassNotFoundException;

}
