package com.example.noservendingmachine.service;

import com.example.noservendingmachine.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class VendingMachineService {

    public ProductDto addProduct(final ProductDto productDto) {
        System.out.println("Product added");
        return productDto;
    }

    public ProductDto updateProduct(final ProductDto productDto) {
        System.out.println("Product updated");
        return productDto;
    }

    public boolean removeProduct(final Long productId) {
        System.out.println("Product removed");
        return true;
    }
}
