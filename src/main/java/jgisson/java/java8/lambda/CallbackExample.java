package jgisson.java.java8.lambda;

import java.util.function.Function;

public class CallbackExample {

  private static Function<Integer, Void> callback = v -> {
    System.out.println("I've been sleeping for " + v + " milliseconds");
    return null;
  };

  public static void job(Function<Integer, Void> fn) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    fn.apply(1000);
  }

  public static void main(String[] args) {
    job(callback);
  }
}
