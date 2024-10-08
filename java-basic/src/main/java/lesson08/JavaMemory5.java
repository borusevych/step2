package lesson08;

public class JavaMemory5 {
  public static void main(String[] args) {
    Pizza p1 = new Pizza("M", 30);
    System.out.println(p1);

    Pizza p2 = new Pizza("4C", 60);
    System.out.println(p2);
    System.out.println(p1);
    // p1:Pizza{name='M',  size=30}
    // p2:Pizza{name='4C', size=60}
    // p1:Pizza{name='M',  size=60}
    Pizza.size = 100;
    System.out.println(p2);
    System.out.println(p1);
    // Pizza{name='4C', size=100}
    // Pizza{name='M', size=100}
  }
}
