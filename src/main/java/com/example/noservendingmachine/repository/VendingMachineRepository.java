package com.example.noservendingmachine.repository;

import com.example.noservendingmachine.model.VendingMachine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendingMachineRepository extends CrudRepository<VendingMachine, Long> {

}
