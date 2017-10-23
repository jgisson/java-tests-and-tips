package jgisson.java.java8.string;

/**
 * Created by jgisson on 14/03/2017.
 */
public class StringTests {

    private static final String VALUE = "VALUE";

    public static void main(String[] args) {
        String v1 = "VALUE";
        System.out.println("v1 Equals " + VALUE  + ": " + VALUE.equals(v1));

        String v2 = null;
        System.out.println("v2 Equals " + VALUE  + ": " + VALUE.equals(v2));
    }

}

