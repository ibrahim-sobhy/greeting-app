package com.telenor.greeting.account.model;

import java.util.stream.Stream;

public enum Type {
    SMALL("small"), BIG("big");
    String type;

    Type(String type) {
        this.type = type;
    }

    public static Stream<Type> stream() {
        return Stream.of(values());
    }

    public String value() {
        return this.type;
    }
}
