package lesson09.data;

public class MegaCat extends Cat {

  public MegaCat(String name) {
    super(name);
  }

  @Override
  public void sound() {
    meow();
  }
}
