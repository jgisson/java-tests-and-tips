package jgisson.java.uuid;

import java.util.UUID;
import com.fasterxml.uuid.Generators;

/**
 * Demonstrates generating and working with different versions of UUIDs in Java.
 * This example uses both the built-in Java UUID class, the FasterXML Java UUID
 * Generator library and the Github UUID Creator library.
 * 
 * For UUID v1 (time-based), v6 (time-based, reordered) and v7 (time-based,
 * sortable), you might need to use additional libraries.
 */
public class UUIDTests {
    public static void main(String[] args) {
        generateUUIDv4();

        // Generate a UUID v1 (time-based)
        generateUUIDv1();

        // fasterxml UUID v6, v7
        fasterxmlGenerateUUIDv6();
        fasterxmlGenerateUUIDv7();

        // Github UUID Creator v1, v6, v7
        githubUUIDCreatorGenerateUUIDv1();
        githubUUIDCreatorGenerateUUIDv6();
        githubUUIDCreatorGenerateUUIDv7();
    }

    /**
     * Generates a UUID version 4 (random - Java built-in)
     */
    public static void generateUUIDv4() {
        // Generate a random UUID
        UUID randomUUID = UUID.randomUUID();
        System.out.println("Random UUID: " + randomUUID);

        // Get UUID properties
        System.out.println("Version: " + randomUUID.version());
        System.out.println("Variant: " + randomUUID.variant());
        System.out.println("Timestamp is not applicable"); // Works Only for v1
    }

    /**
     * Generates a UUID version 1 (time-based)
     */
    public static void generateUUIDv1() {
        UUID uuidV1 = Generators.timeBasedGenerator().generate();
        System.out.println("UUID v1 (time-based): " + uuidV1);

        // Get UUID properties
        System.out.println("Version (v1): " + uuidV1.version());
        System.out.println("Variant (v1): " + uuidV1.variant());
        System.out.println("Timestamp (v1): " + uuidV1.timestamp());
    }

    /**
     * Generates a UUID version 6 (time-based, reordered)
     */
    public static void fasterxmlGenerateUUIDv6() {
        UUID uuidV6 = Generators.timeBasedReorderedGenerator().generate();
        System.out.println("UUID v6 (time-based, reordered): " + uuidV6);

        // Get UUID properties
        System.out.println("Version (v6): " + uuidV6.version());
        System.out.println("Variant (v6): " + uuidV6.variant());
        // System.out.println("Timestamp (v6): " + uuidV6.timestamp());
    }

    /**
     * Generates a UUID version 7 (time-based, sortable)
     */
    public static void fasterxmlGenerateUUIDv7() {
        UUID uuidV7 = Generators.timeBasedEpochGenerator().generate();
        System.out.println("UUID v7 (time-based, sortable): " + uuidV7);

        // Get UUID properties
        System.out.println("Version (v7): " + uuidV7.version());
        System.out.println("Variant (v7): " + uuidV7.variant());
        // System.out.println("Timestamp (v7): " + uuidV7.timestamp());
    }

    public static void githubUUIDCreatorGenerateUUIDv1() {
        UUID uuidV1 = com.github.f4b6a3.uuid.UuidCreator.getTimeBased();
        System.out.println("Github UUID Creator v1 (time-based): " + uuidV1);

        // Get UUID properties
        System.out.println("Version (v1): " + uuidV1.version());
        System.out.println("Variant (v1): " + uuidV1.variant());
        System.out.println("Timestamp (v1): " + uuidV1.timestamp());

    }

    public static void githubUUIDCreatorGenerateUUIDv6() {
        UUID uuidV6 = com.github.f4b6a3.uuid.UuidCreator.getTimeOrdered();
        System.out.println("Github UUID Creator v6 (time-based, reordered): " + uuidV6);

        // Get UUID properties
        System.out.println("Version (v6): " + uuidV6.version());
        System.out.println("Variant (v6): " + uuidV6.variant());
        // System.out.println("Timestamp (v6): " + uuidV6.timestamp());
    }

    public static void githubUUIDCreatorGenerateUUIDv7() {
        UUID uuidV7 = com.github.f4b6a3.uuid.UuidCreator.getTimeOrderedEpoch();
        System.out.println("Github UUID Creator v7 (time-based, sortable): " + uuidV7);

        // Get UUID properties
        System.out.println("Version (v7): " + uuidV7.version());
        System.out.println("Variant (v7): " + uuidV7.variant());
        // System.out.println("Timestamp (v7): " + uuidV7.timestamp());
    }

}