package jgisson.java.java8.string;

/**
 * Created by jgisson on 14/03/2017.
 */
public class StringTests {

    private static final String VALUE = "VALUE";

    public static void main(String[] args) {
        String v1 = "VALUE";
        System.out.println("v1 Equals " + VALUE  + ": " + VALUE.equals(v1));
        System.out.println("v1 == VALUE: " + (v1 == VALUE));

        String v2 = null;
        System.out.println("v2 Equals " + VALUE  + ": " + VALUE.equals(v2));

        String v3 = new String("VALUE");
        System.out.println("v3 Equals " + VALUE  + ": " + VALUE.equals(v3));
        System.out.println("v3 == VALUE: " + (v3 == VALUE));

        buildBigString();
    }

    // Show how editors, Sonarlint and code assists can help to optimize code
    private static void buildBigString() {

        String bigString = "ABCDEFGH";

        for (int i = 0; i < 10000; i++) {
            bigString = bigString + " " + VALUE;
        }

        System.out.println(bigString.length());
    }

}

