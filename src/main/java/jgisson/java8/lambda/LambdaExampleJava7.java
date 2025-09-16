package jgisson.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExampleJava7 {

  public static void main(String[] args) {
    List<String> values = Arrays
        .asList("Paris", "Lille", "Lyon", "Bordeaux", "Nice", "Grenoble", "Marseille");

    Collections.sort(values, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });

    System.out.println(values);
  }
}
