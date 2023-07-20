package com.example.noservendingmachine.dto.money;

public abstract class Banknote extends Money {
    protected Banknote(final int value) {
        super(value);
    }
}
