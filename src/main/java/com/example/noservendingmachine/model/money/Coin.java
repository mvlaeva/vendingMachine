package com.example.noservendingmachine.model.money;

public abstract class Coin {
    private final int value;

    protected Coin(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
