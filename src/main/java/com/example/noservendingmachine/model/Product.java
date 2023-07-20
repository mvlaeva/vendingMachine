package com.example.noservendingmachine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private final String name;
    private final float price;
}
