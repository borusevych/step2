package lesson07;

public class DataComparing {

  public static void main(String[] args) {
    int x = 5;
    int y = 5;
    System.out.println(x == y); // true

    Pizza p1 = new Pizza("Margarita");
    Pizza p2 = new Pizza("Margarita");
    System.out.println(p1.equals(p2)); // true
    System.out.println(p1.equals(p1)); // true
    System.out.println(p1.equals(null)); // false
    System.out.println(p1.equals("M")); // false
    System.out.println(p1.equals(new int[]{123})); // false

    System.out.println(p1 == p2); // false
    System.out.println(p1 == p1); // true

    String s1 = "java";
    String s2 = "java";
    System.out.println(s1 == s2); // true

    String s3 = "ja".concat("va");
    System.out.println(s1 == s3); // false

    String s4 = new String("java");
    String s5 = new String("java");
    System.out.println(s4 == s5); // false
  }

}
