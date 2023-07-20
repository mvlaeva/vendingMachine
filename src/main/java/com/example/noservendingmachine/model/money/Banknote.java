package com.example.noservendingmachine.model.money;

public abstract class Banknote {
    private final int value;

    protected Banknote(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
