package lesson05;

public class StringsLength {

  public static void main(String[] args) {
    String s1 = "hello";
    String s2 = "привіт";
    String s3 = "नमस्ते";
    String s3a ="न म स ् त े";
    String s4 = "😀🤪😐🙄";

    System.out.println(s1.length()); // 5+
    System.out.println(s2.length()); // 6+
    System.out.println(s3.length()); // ...6
    System.out.println(s4.length()); // 8+

    System.out.println(s1.getBytes().length); // 5 * 1 = 5
    System.out.println(s2.getBytes().length); // 6 * 2 = 12
    System.out.println(s3.getBytes().length); // 6 * 3 = 18
    System.out.println(s4.getBytes().length); // ...16




  }

}
