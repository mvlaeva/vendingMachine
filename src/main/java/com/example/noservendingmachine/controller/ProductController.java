package com.example.noservendingmachine.controller;

import com.example.noservendingmachine.dto.ProductDto;
import com.example.noservendingmachine.exception.DependencyFailedException;
import com.example.noservendingmachine.service.VendingMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Buy a product from the vending machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product bought successfully"),
            @ApiResponse(responseCode = "400", description = "No such product in the vending machine or insufficient funds")})
    @PutMapping("/buy")
    public ResponseEntity<String> buyProduct(@RequestBody final ProductDto productDto) {
        return new ResponseEntity<>(vendingMachineService.buyProduct(productDto), HttpStatus.OK);
    }

    @Operation(summary = "Add a product in the vending machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product added successfully"),
            @ApiResponse(responseCode = "400", description = "Maximum capacity exceeded")})
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody final ProductDto productDto) {
        return new ResponseEntity<>(vendingMachineService.addProduct(productDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Update a product in the vending machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "400", description = "No such product in the vending machine")})
    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody final ProductDto productDto) {
        return new ResponseEntity<>(vendingMachineService.updateProduct(productDto), HttpStatus.OK);
    }


    @Operation(summary = "Delete a product from the vending machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "No such product in the vending machine")})
    @DeleteMapping("/{productId}")
    public ResponseEntity<Long> deleteProduct(@PathVariable final Long productId) {
        var isDeleted = vendingMachineService.deleteProduct(productId);

        if (isDeleted) {
            return new ResponseEntity<>(productId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(productId, HttpStatus.NOT_FOUND);
        }
    }
}
