package sql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DAO<A> {
    default List<A> showAll() throws IOException {
        return  new ArrayList<>();
    }
    default void saveAll(List<A> a) throws IOException {}
    default void save(A a) throws IOException {}
    default void update(A a) throws IOException {}
    default void delete(A a) throws IOException {}
}