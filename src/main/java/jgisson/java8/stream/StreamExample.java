package jgisson.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

  private static Function<String, Predicate<String>> contains = seq -> v -> {
//    System.out.println("contains : " + v);
    return v.toLowerCase().contains(seq);
  };
  private static boolean lengthSup6(String s) {
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    System.out.println("lengthSup6 : " + s);
    return s.length() >= 6;
  }

  public static void main(String[] args) {
    List<String> values = Arrays.asList("Paris", "Lille", "Lyon", "Bordeaux", "Nice", "Grenoble", "Marseille");

    Stream<String> result = values.stream().filter(Objects::nonNull).filter(contains.apply("l")).filter(StreamExample::lengthSup6);

    System.out.println(result.collect(Collectors.toList()));
  }

}
