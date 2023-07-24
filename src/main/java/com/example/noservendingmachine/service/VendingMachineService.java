package com.example.noservendingmachine.service;

import com.example.noservendingmachine.dto.ProductDto;
import com.example.noservendingmachine.exception.BusinessLogicException;
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

    public String buyProduct(final ProductDto productDto) {
        final String productName = productDto.getName();
        final Product product = vendingMachine.getProducts().stream()
                .filter(prod -> prod.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new BusinessLogicException("The vending machine does not contain the given product: " + productName));

        if (vendingMachine.getProducts().stream().noneMatch(prod -> prod.getName().equals(productName))) {
            throw new BusinessLogicException("The vending machine does not contain the given product: " + productName);
        }
        if (product.getPrice() <= vendingMachine.getInsertedMoney()) {
            final float change = vendingMachine.buyProduct(product);
            vendingMachineRepository.save(vendingMachine);
            return "You bought " + productName + " and got change of: " + change;
        } else {
            throw new BusinessLogicException("You are trying to buy a product costing " + product.getPrice() +
                    " with " + vendingMachine.getInsertedMoney() + " in the vending machine!");
        }
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
        vendingMachineRepository.save(vendingMachine);
    }

    public float returnInsertedMoney() {
        final float previouslyInsertedMoney = vendingMachine.returnInsertedMoney();
        vendingMachineRepository.save(vendingMachine);
        return previouslyInsertedMoney;
    }
}
