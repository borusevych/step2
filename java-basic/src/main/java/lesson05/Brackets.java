package lesson05;

public class Brackets {

  static boolean isValid(String s) {
    int count = 0;
    for (char c: s.toCharArray()) {
      switch (c) {
        case '{': count++; break;
        case '}':
          if (count == 0) return false;
          count--; break;
        default:
      }
    }
    return count == 0;
  }

  public static void main(String[] args) {
    System.out.println(isValid("{}{}{{{}}{}}{}{}"));
    System.out.println(isValid("{}{}{{{}}{}}{}{}}"));
    System.out.println(isValid("{}{}{{{}}{}}{}{"));

    System.out.println(isValid("}{"));
    System.out.println(isValid("}{}{}{{{}}{}}{}{}"));
  }


}
