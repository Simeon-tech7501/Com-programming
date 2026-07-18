package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IDGenerator {
    private static AtomicInteger counter = new AtomicInteger(1000);

    public static String generateId(String prefix) {
        return prefix + counter.incrementAndGet();
    }
}
