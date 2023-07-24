package com.example.noservendingmachine.dto.money;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("10lv")
public class TenLev extends Banknote {
    protected TenLev() {
        super(1000);
    }
}
