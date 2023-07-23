package com.example.noservendingmachine.dto;

import com.example.noservendingmachine.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    private final Long id;
    @NotBlank
    @Size(min = 4, message = "Product name should have at least 4 characters")
    private final String name;
    @NotNull
    private final Float price;

    public Product mapToProduct() {
        return new Product(id, name, price);
    }
}
