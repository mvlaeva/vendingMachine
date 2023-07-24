package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("20st")
public class FifthLev extends Coin {
    public FifthLev() {
        super(20);
    }
}
