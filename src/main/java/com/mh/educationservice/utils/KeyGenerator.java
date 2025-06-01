package com.mh.educationservice.utils;

import java.util.UUID;

public class KeyGenerator {
    private KeyGenerator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String generateWithPrefix(String prefix) {
        return (prefix + "-" + UUID.randomUUID()).toUpperCase();
    }
}
