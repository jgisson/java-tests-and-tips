package jgisson.java.java8.string;

/**
 * Created by jgisson: String perf tests.
 * Use Java Microbenchmark Harness for more benchmark option.
 */
public class StringPerf {

    private static final int ITERATIONS = 10000;
    private static final String VALUE = "VALUE";

    public static void main(String[] args) {
        measureStringBuilderPerformance();
        measureStringConcatPerformance();
    }

    private static void measureStringBuilderPerformance() {
        long startTime = System.nanoTime();
        long startMemory = Runtime.getRuntime().freeMemory();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(VALUE);
        }

        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().freeMemory();

        System.out.println("StringBuilder Time taken: " + (endTime - startTime) + " ns");
        System.out.println("StringBuilder Memory used: " + (startMemory - endMemory) + " bytes");
    }

    private static void measureStringConcatPerformance() {
        long startTime = System.nanoTime();
        long startMemory = Runtime.getRuntime().freeMemory();

        String str = "";
        for (int i = 0; i < ITERATIONS; i++) {
            str += VALUE;
        }

        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().freeMemory();

        System.out.println("String Concat Time taken: " + (endTime - startTime) + " ns");
        System.out.println("String Concat Memory used: " + (startMemory - endMemory) + " bytes");
    }
}

