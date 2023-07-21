package com.example.noservendingmachine.service;

import com.example.noservendingmachine.dto.ProductDto;
import com.example.noservendingmachine.model.Product;
import com.example.noservendingmachine.model.VendingMachine;
import org.springframework.stereotype.Service;

@Service
public class VendingMachineService {

    private final VendingMachine vendingMachine = new VendingMachine();

    public ProductDto addProduct(final ProductDto productDto) {
        final Product product = new Product(productDto.getName(), productDto.getPrice());
        vendingMachine.addProduct(product);
        System.out.println("Product added");
        return productDto;
    }

    public ProductDto updateProduct(final ProductDto productDto) {
        final Product product = new Product(productDto.getName(), productDto.getPrice());
        vendingMachine.updateProduct(product);
        System.out.println("Product updated");
        return productDto;
    }

    public boolean removeProduct(final String productName) {
        System.out.println("Product removed");
        return vendingMachine.removeProduct(productName);
    }

    public void addMoney(final float insertedMoney) {
        vendingMachine.addMoney(insertedMoney);
    }

    public float returnInsertedMoney() {
        return vendingMachine.returnInsertedMoney();
    }
}
