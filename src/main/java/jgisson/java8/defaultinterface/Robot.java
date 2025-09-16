package jgisson.java8.defaultinterface;

public interface Robot {
  boolean move();

  default String describe() {
    return "Hello I'm a robot";
  }

}
