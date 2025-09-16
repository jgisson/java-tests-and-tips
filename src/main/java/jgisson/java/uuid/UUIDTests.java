package jgisson.java.uuid;

import java.util.UUID;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import com.fasterxml.uuid.impl.TimeBasedReorderedGenerator;

public class UUIDTests {
    public static void main(String[] args) {
        generateUUIDv4();

        // Generate a UUID v1 (time-based)
        generateUUIDv1();

        // Generate a UUID v6 (time-based, reordered)
        generateUUIDv6();

        // Generate a UUID v7 (time-based, sortable)
        generateUUIDv7();
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
    public static void generateUUIDv6() {
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
    public static void generateUUIDv7() {
        UUID uuidV7 = Generators.timeBasedEpochGenerator().generate();
        System.out.println("UUID v7 (time-based, sortable): " + uuidV7);

        // Get UUID properties
        System.out.println("Version (v7): " + uuidV7.version());
        System.out.println("Variant (v7): " + uuidV7.variant());
        // System.out.println("Timestamp (v7): " + uuidV7.timestamp());
    }
}