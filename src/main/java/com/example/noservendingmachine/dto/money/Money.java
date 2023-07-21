package com.example.noservendingmachine.dto.money;

import jakarta.validation.constraints.NotNull;

public abstract class Money {
    @NotNull
    private final Integer value;

    protected Money(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
