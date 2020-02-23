package com.telenor.greeting.account.model;

import java.util.Arrays;
import java.util.stream.Stream;

public enum AccountType {
    PERSONAL("personal"), BUSINESS("business");
    String type;
    AccountType(String type) {
        this.type = type;
    }

    public static Stream<AccountType> stream() {
        return Stream.of(values());
    }

    public String value() {
        return this.type;
    }
}
