package com.example.noservendingmachine.dto.money;

public abstract class Banknote extends Money {
    protected Banknote(final float value) {
        super(value);
    }
}
