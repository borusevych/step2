package lesson12;

import java.util.Iterator;

public class Randoms implements Iterable<Integer> {

  private final int min;
  private final int max;
  private final int count;

  public Randoms(int min, int max, int count) {
    this.min = min;
    this.max = max;
    this.count = count;
  }

  private int nextValue() {
    return (int) (Math.random() * (max - min) + min);
  }

  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < count;
      }

      @Override
      public Integer next() {
        index++;
        return nextValue();
      }
    };
  }
}
