package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("10st")
public class Dime extends Coin {
    public Dime() {
        super(10);
    }
}
