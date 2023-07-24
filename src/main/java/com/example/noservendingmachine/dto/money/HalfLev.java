package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("50st")
public class HalfLev extends Coin {
    public HalfLev() {
        super(0.5f);
    }
}