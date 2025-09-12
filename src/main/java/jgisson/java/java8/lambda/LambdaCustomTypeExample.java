package jgisson.java.java8.lambda;

public class LambdaCustomTypeExample {

  public static void main(String[] args) {
    Formatter<String, String, Integer, Integer, String> formatter = (equipe1, equipe2, r1, r2) ->
        equipe1 + " " + r1 + "-" + r2 + " " + equipe2;

    System.out.printf(formatter.format("France", "Allemagne", 3, 2));
  }

  @FunctionalInterface
  interface Formatter<T1, T2, T3, T4, R> {

    R format(T1 v1, T2 v2, T3 v3, T4 v4);
  }

}
