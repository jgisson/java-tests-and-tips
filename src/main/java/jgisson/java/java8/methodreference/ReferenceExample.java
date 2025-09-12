package jgisson.java.java8.methodreference;

@FunctionalInterface
interface Converter<T, R> {
  R convert(T s);
}

class Car {
  public String convertLength(Integer v) {
    return "value = " + String.valueOf(v);
  }
}

class Person {
  private String name;
  private Integer age;

  public Person() {
    name = "foo";
    age = 12;
  }

  public Person(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

interface PersonFactory <P extends Person> {
  P create(String name, Integer age);
}

public class ReferenceExample {

  public static void main(String[] args) {
    Converter<String, Integer> converter = Integer::valueOf;
    System.out.println(converter.convert("12"));

    Car car = new Car();
    Converter<Integer, String> instanceConverter = car::convertLength;
    System.out.println(instanceConverter.convert(2));

    PersonFactory personFactory = Person::new;
    Person person = personFactory.create("bar", 21);
    System.out.println(person);
  }
}
