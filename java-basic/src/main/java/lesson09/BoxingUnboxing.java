package lesson09;

public class BoxingUnboxing {

  public static void main(String[] args) {
    int x = 5;

    Integer k = Integer.valueOf(x); // explicit Boxing: z = new Integer(x)
    int a = k.intValue(); // explicit unboxing

    Integer y = 10; // AutoBoxing y = new Integer(10)
    Integer z = x;  // AutoBoxing: z = new Integer(x)
    int l = z;      // AutoUnboxing: z.intValue();

    Integer m = null;
    int q = m; // exception

    // "z"
    String s = "\"z\"";
    String s1 =
      """
      {
        "z" : 1,
        "name" : "jim"
      }
      """;

  }

}
