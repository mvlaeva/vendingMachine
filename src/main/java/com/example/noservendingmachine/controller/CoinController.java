package com.example.noservendingmachine.controller;

import com.example.noservendingmachine.dto.money.Money;
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

    @Operation(summary = "Insert money in the vending machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Money inserted successfully"),
            @ApiResponse(responseCode = "400", description = "Validation didn't pass")})
    @PostMapping
    public ResponseEntity<HttpStatus> insertMoney(@Valid @RequestBody final Money money) {
        vendingMachineService.addMoney(money.getValue());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Return previously inserted money in the vending machine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Money returned successfully"),
            @ApiResponse(responseCode = "400", description = "No money previously inserted")})
    @PutMapping
    public ResponseEntity<Float> returnInsertedMoney() {
        return new ResponseEntity<>(vendingMachineService.returnInsertedMoney(), HttpStatus.OK);
    }
}
