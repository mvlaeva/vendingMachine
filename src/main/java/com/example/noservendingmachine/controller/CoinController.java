package com.example.noservendingmachine.controller;

import com.example.noservendingmachine.dto.money.Money;
import com.example.noservendingmachine.exception.DependencyFailedException;
import com.example.noservendingmachine.service.VendingMachineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/coins")
public class CoinController {

    final VendingMachineService vendingMachineService;

    public CoinController(final VendingMachineService vendingMachineService) {
        if (vendingMachineService != null) {
            this.vendingMachineService = vendingMachineService;
        } else {
            throw new DependencyFailedException("You need to provide a VendingMachineService bean!");
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> insertMoney(@Valid @RequestBody final Money money) {
        vendingMachineService.addMoney(money.getValue());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Float> returnInsertedMoney() {
        return new ResponseEntity<>(vendingMachineService.returnInsertedMoney(), HttpStatus.OK);
    }
}
