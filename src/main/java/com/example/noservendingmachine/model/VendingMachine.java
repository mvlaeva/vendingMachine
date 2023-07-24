package com.example.noservendingmachine.model;

import com.example.noservendingmachine.exception.BusinessLogicException;
import com.example.noservendingmachine.exception.MaximumCapacityExceededException;
import com.example.noservendingmachine.exception.MinimumCapacityReached;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "vending_machines")
@NoArgsConstructor
public class VendingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public static final int MAX_CAPACITY = 10;

    @OneToMany
    private final List<Product> products = new ArrayList<>(10);

    private float insertedMoney = 0;

    public void addProduct(final Product product) {
        if (products.size() < MAX_CAPACITY) {
            products.add(product);
        } else {
            throw new MaximumCapacityExceededException("The max capacity of the vending machine is " + MAX_CAPACITY + " products!");
        }
    }

    public boolean removeProduct(final Long productId) {
        if (products.size() > 0) {
            return products.removeIf(prod -> prod.getId().equals(productId));
        } else {
            throw new MinimumCapacityReached("There are no products currently in the vending machine!");
        }
    }

    public float buyProduct(final Product product) {
        if (products.size() > 0) {
            if (products.removeIf(prod -> prod.getId().equals(product.getId()))) {
                final float change = insertedMoney - product.getPrice();
                insertedMoney = 0;
                return change;
            } else {
                throw new BusinessLogicException("No such product in the vending machine: " + product.getName() + "!");
            }
        } else {
            throw new MinimumCapacityReached("There are no products currently in the vending machine!");
        }
    }

    public void updateProduct(final Product product) {
        if (products.size() > 0) {
            products.removeIf(prod -> prod.getId().equals(product.getId()));
            products.add(product);
        } else {
            throw new MinimumCapacityReached("There are no products currently in the vending machine!");
        }
    }

    public void addMoney(final float insertedMoney) {
        if (insertedMoney > 0) {
            this.insertedMoney += insertedMoney;
        } else {
            throw new BusinessLogicException("Inserting negative or zero sum in a vending machine does not make any sense!");
        }
    }

    public float returnInsertedMoney() {
        if (insertedMoney > 0) {
            float moneyToReturn = insertedMoney;
            insertedMoney = 0;
            return moneyToReturn;
        } else {
            throw new BusinessLogicException("No money were previously inserted!");
        }
    }
}
