package jgisson.java8.lambda;

import java.util.function.Function;

public class LambdaTypeExample {

  private static Function<Integer, Boolean> isEven = n -> n % 2 == 0;

  public static void main(String[] args) {
    System.out.println("is 3 even : " + isEven.apply(3));
    System.out.println("is 16 even : " + isEven.apply(16));
  }

}
