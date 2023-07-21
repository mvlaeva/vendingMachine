package com.example.noservendingmachine.model;

import com.example.noservendingmachine.exception.BusinessLogicException;
import com.example.noservendingmachine.exception.MaximumCapacityExceededException;
import com.example.noservendingmachine.exception.MinimumCapacityReached;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VendingMachine {
    public static final int MAX_CAPACITY = 10;
    private final List<Product> products = new ArrayList<>(10);

    private int insertedMoney = 0;

    public void addProduct(final Product product) {
        if (products.size() < MAX_CAPACITY) {
            products.add(product);
        } else {
            throw new MaximumCapacityExceededException("The max capacity of the vending machine is " + MAX_CAPACITY + " products!");
        }
    }

    public boolean removeProduct(final String productName) {
        if (products.size() > 0) {
            return products.removeIf(prod -> prod.getName().equals(productName));
        } else {
            throw new MinimumCapacityReached("There are no products currently in the vending machine!");
        }
    }

    public void updateProduct(final Product product) {
        if (products.size() > 0) {
            products.removeIf(prod -> prod.getName().equals(product.getName()));
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
            return insertedMoney;
        } else {
            throw new BusinessLogicException("No money were previously inserted!");
        }
    }
}
