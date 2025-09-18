package jgisson.java.uuid;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochGenerator;
import com.github.f4b6a3.uuid.UuidCreator;

/**
 * This class tests the uniqueness and perfs of UUIDs generated in a multi-threaded
 * environment.
 * It spawns multiple threads, each generating a specified number of UUIDs,
 * and checks for collisions.
 * 
 * Tests are done using three different libraries:
 * - Java built-in UUID generation (random-based / v4) : around 5 seconds on Mac M2
 * - GitHub f4b6a3 UUID Creator (time-ordered epoch-based / v7) : around 8 seconds on Mac M2
 * - FasterXML Java UUID Generator (time-based epoch-based / v7) : around 2 seconds on Mac M2
 */
public class UUIDTestsPref {

    private static final String LIB_JAVA_BUILT_IN = "Java built-in";
    private static final String LIB_GITHUB_F4B6A3 = "GitHub f4b6a3";
    private static final String LIB_FASTERXML_UUID = "FasterXML";

    private static final TimeBasedEpochGenerator fasterxmlGeneratorUUIDv7 = Generators.timeBasedEpochGenerator();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("UUID Tests Pref");

        int threadCount = 128;
        int iterationCount = 100_000;
        Map<UUID, Long> uuidMap = new ConcurrentHashMap<>();
        AtomicLong collisionCount = new AtomicLong();
        long startNanos = System.nanoTime();
        CountDownLatch endLatch = new CountDownLatch(threadCount);

        String lib = LIB_FASTERXML_UUID;
        System.out.println("Testing " + lib + " UUID generation");

        for (long i = 0; i < threadCount; i++) {
            long threadId = i;
            new Thread(() -> {
                for (long j = 0; j < iterationCount; j++) {
                    UUID uuid = generateUUID(lib);
                    Long existingUUID = uuidMap.put(uuid, (threadId * iterationCount) + j);
                    if (existingUUID != null) {
                        collisionCount.incrementAndGet();
                    }
                }
                endLatch.countDown();
            }).start();
        }

        endLatch.await();
        System.out.println(threadCount * iterationCount + " UUIDs generated, " + collisionCount + " collisions in "
                + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + "ms");
    }

    private static UUID generateUUID(String lib) {
        if (LIB_JAVA_BUILT_IN.equals(lib)) {
            return UUID.randomUUID();
        } else if (LIB_GITHUB_F4B6A3.equals(lib)) {
            return UuidCreator.getTimeOrderedEpoch();
        } else if (LIB_FASTERXML_UUID.equals(lib)) {
            return fasterxmlGeneratorUUIDv7.generate();
        } else {
            throw new IllegalArgumentException("Unknown library: " + lib);
        }
    }

}
