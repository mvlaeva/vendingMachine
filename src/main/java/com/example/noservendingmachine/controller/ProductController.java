package com.example.noservendingmachine.controller;

import com.example.noservendingmachine.dto.ProductDto;
import com.example.noservendingmachine.exception.DependencyFailedException;
import com.example.noservendingmachine.service.VendingMachineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    final VendingMachineService vendingMachineService;

    public ProductController(final VendingMachineService vendingMachineService) {
        if (vendingMachineService != null) {
            this.vendingMachineService = vendingMachineService;
        } else {
            throw new DependencyFailedException("You need to provide a VendingMachineService bean!");
        }
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody final ProductDto productDto) {
        return new ResponseEntity<>(vendingMachineService.addProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody final ProductDto productDto) {
        return new ResponseEntity<>(vendingMachineService.updateProduct(productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Long> updateProduct(@PathVariable final Long productId) {
        var isDeleted = vendingMachineService.removeProduct(productId);

        if (isDeleted) {
            return new ResponseEntity<>(productId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(productId, HttpStatus.NOT_FOUND);
        }
    }
}