package com.example.noservendingmachine.service;

import com.example.noservendingmachine.dto.ProductDto;
import com.example.noservendingmachine.model.Product;
import com.example.noservendingmachine.model.VendingMachine;
import com.example.noservendingmachine.repository.ProductRepository;
import com.example.noservendingmachine.repository.VendingMachineRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VendingMachineService {

    private final VendingMachine vendingMachine = new VendingMachine();

    private final ProductRepository productRepository;
    private final VendingMachineRepository vendingMachineRepository;

    public VendingMachineService(final ProductRepository productRepository, final VendingMachineRepository vendingMachineRepository) {
        this.productRepository = productRepository;
        this.vendingMachineRepository = vendingMachineRepository;
    }

    public ProductDto addProduct(final ProductDto productDto) {
        final Product product = productRepository.save(productDto.mapToProduct());
        vendingMachine.addProduct(product);
        vendingMachineRepository.save(vendingMachine);
        System.out.println("Product added");
        return product.mapToProductDto();
    }

    public ProductDto updateProduct(final ProductDto productDto) {
        if (productRepository.findById(productDto.getId()).isPresent()) {
            final Product product = productRepository.save(productDto.mapToProduct());
            vendingMachine.updateProduct(product);
            vendingMachineRepository.save(vendingMachine);
            System.out.println("Product updated");
            return product.mapToProductDto();
        } else {
            throw new NoSuchElementException("No product with id " + productDto.getId() + " has been found!");
        }
    }

    public boolean deleteProduct(final Long productId) {
        boolean isRemoved = vendingMachine.removeProduct(productId);
        System.out.println("Product removed");
        vendingMachineRepository.save(vendingMachine);
        return isRemoved;
    }

    public void addMoney(final float insertedMoney) {
        vendingMachine.addMoney(insertedMoney);
    }

    public float returnInsertedMoney() {
        return vendingMachine.returnInsertedMoney();
    }
}
