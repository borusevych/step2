package lesson05;

public class StringsApp {

  public static void main(String[] args) {
    String s1 = "Hello"; // String Pool
    var s2 = ", world!"; // String Pool
    var s = s1 + s2; // Heap
    String s3 = s1.concat(s2);
    boolean e = s1.isEmpty();
    boolean c1 = s.contains("ll");// true
    boolean c2 = s.contains("a");// false
    boolean c3 = s.startsWith("H"); // true
    boolean c4 = s.startsWith("o"); // true
    String s4 = s.toLowerCase();
    String s5 = s.toUpperCase();
    //                     [    )
    String s6 = s.substring(3, 5);
    String s7 = s.replace("lo", "p");
    char c = s1.charAt(0);
    String trimmed = s1.trim(); //

    for (int i = 0; i < s1.length(); i++) {
      System.out.printf("%s ", s1.charAt(i));
    }

    for (char ch: s2.toCharArray()) {
      System.out.printf("%s ", ch);
    }
  }

}
