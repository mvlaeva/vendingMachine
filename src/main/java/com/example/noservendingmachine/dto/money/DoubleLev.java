package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("2lv")
public class DoubleLev extends Coin {
    public DoubleLev() {
        super(200);
    }
}
