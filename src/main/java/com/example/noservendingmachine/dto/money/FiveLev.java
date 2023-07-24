package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("5lv")
public class FiveLev extends Banknote {
    protected FiveLev() {
        super(500);
    }
}
