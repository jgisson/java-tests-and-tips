package jgisson.java.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

  public static void main(String[] args) {
    List<String> values = Arrays
        .asList("Paris", "Lille", "Lyon", "Bordeaux", "Nice", "Grenoble", "Marseille");

    Collections.sort(values, (o1, o2) -> o1.compareTo(o2));

    System.out.println(values);
  }
}
