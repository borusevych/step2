package lesson08;

public class JavaMemory6 {

  int x;

  class Inside6 {
    int y;

    void whateverIwant() {
      int x1 = x;
    }
  }

  static class Inside6S {
    int y;

    void whateverIwant() {
//      int x1 = x;
    }
  }

  void whatever() {
    Inside6 inside6 = new Inside6();
    int y = inside6.y;
  }

}
