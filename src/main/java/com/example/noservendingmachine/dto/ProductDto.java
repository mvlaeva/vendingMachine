package com.example.noservendingmachine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    @NotBlank
    @Size(min = 4, message = "Product name should have at least 4 characters")
    private final String name;
    @NotNull
    private final Float price;
}
