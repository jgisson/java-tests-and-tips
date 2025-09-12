package jgisson.java.java8.thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorsTests {

    // Must be centralised in App
    static ForkJoinPool forkJoinPool = new ForkJoinPool(16);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // testSingleThreadExecutor();
        // testExecutorsFuture();
        // testJavaScheduledThreadPool();
        testStreamParallel();
    }

    private static void testSingleThreadExecutor() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> System.out.println(0 + 1));
        executor.submit(() -> System.out.println(0 + 2));
        System.out.println("SingleThreadExecutor Done.");
    }

    private static void testExecutorsFuture() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executor.submit(() -> {
            System.out.println("  Future 1 start");
            Thread.sleep(2000);
            System.out.println("  Future 1 wakeup");
            return 0 + 1;
        });

        Future<Integer> future2 = executor.submit(() -> {
            System.out.println("  Future 2 start");
            return 0 + 2;
        });

        System.out.println("  Result: " + (future1.get() + future2.get()));

        System.out.println("ExecutorsFuture Done.");
    }

    private static void testJavaScheduledThreadPool() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("OK"), 5, 1, TimeUnit.SECONDS);

        System.out.println("JavaScheduledThreadPool Done.");
    }

    private static void testStreamParallel() throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread());

        // Use specific ForkJoinPool instead of default parallel pool
        forkJoinPool.submit(() -> IntStream.range(0, 100)
                .parallel()
                .mapToObj(t -> Thread.currentThread())
                .distinct()
                .forEach(System.out::println))
                .get();

        System.out.println("StreamParallel Done.");
    }

}
