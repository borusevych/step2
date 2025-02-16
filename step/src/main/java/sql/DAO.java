package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface DAO<A> {
    default List<A> showAll() throws IOException {
        return  new ArrayList<>();
    }
    default void saveAll(List<A> a) throws IOException {}
    default void save(A a) throws IOException {}
    default void update(long id) throws IOException {}
    default void delete(long id) throws IOException {}
}