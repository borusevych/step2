package web;

import java.util.Optional;

public class CalcService {

  private final Calc calc = new Calc();

  private static Optional<Integer> toInt(String s) {
    try {
      int x = Integer.parseInt(s);
      return Optional.of(x);
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

  public String doCalc(
    Optional<String> maybeSx,
    Optional<String> maybeSy,
    Optional<String> maybeSop
  ) {
    Optional<Integer> ox = maybeSx.flatMap(CalcService::toInt);
    Optional<Integer> oy = maybeSy.flatMap(CalcService::toInt);

    record Result(int z, String op) { }

    //if (ox.isEmpty()) return "`x` is required, but not given, or not integer";
    int x = ox.get();

    //if (oy.isEmpty()) return "`y` is required, but not given, or not integer";
    int y = oy.get();

    return maybeSop.flatMap(op ->
        switch (op) {
          case "add" -> Optional.of(new Result(calc.add(x, y), "+"));
          case "sub" -> Optional.of(new Result(calc.sub(x, y), "-"));
          default -> Optional.empty();
        }
      ).map(r -> String.format("%d %s %d = %d", x, r.op, y, r.z))
      .orElse("parameter op is not specified or not supported, supported are: `add`, `sub`");
  }

}
