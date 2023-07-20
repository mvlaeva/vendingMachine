package com.example.noservendingmachine.dto.money;

public abstract class Money {
    private final int value;

    protected Money(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
