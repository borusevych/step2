package lesson15;

import java.util.Iterator;

public record NonEmptyArray<A>(A head, A[] tail) implements Iterable<A> {
  @Override
  public Iterator<A> iterator() {
    return new Iterator<>() {
      int index = -1;

      @Override
      public boolean hasNext() {
        return index < tail.length;
      }

      @Override
      public A next() {
        if (index == -1) {
          index++;
          return head;
        } else {
          return tail[index++];
        }
      }
    };
  }
}