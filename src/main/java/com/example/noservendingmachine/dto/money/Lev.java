package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("1lv")
public class Lev extends Coin {
    public Lev() {
        super(100);
    }
}
