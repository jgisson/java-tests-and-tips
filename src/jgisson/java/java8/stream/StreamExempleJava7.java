package jgisson.java.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExempleJava7 {

  private static boolean lengthSup6(String s) {
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    return s.length() >= 6;
  }

  public static void main(String[] args) {
    List<String> values = Arrays
        .asList("Paris", "Lille", "Lyon", "Bordeaux", "Nice", "Grenoble", "Marseille");

    List<String> result = new ArrayList<>();

    for (String city : values) {
      if (city != null && city.toLowerCase().contains("l") && lengthSup6(city)) {
        result.add(city);
      }
    }

    System.out.println(result);
  }

}
