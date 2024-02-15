package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.AddressDTO;
import com.adrian.employeemanager.model.Address;
import com.adrian.employeemanager.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping
    public ResponseEntity<Address> createEntity(@RequestBody AddressDTO addressDTO) {
        System.out.println(addressDTO.toString());
        Address createdAddress = addressService.createAddressFromDTO(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }


    public ResponseEntity<Address> findById(Long aLong) {
        return null;
    }


    public ResponseEntity<Address> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }


    public ResponseEntity<List<Address>> findAllByEmployeeId(Long aLong) {
        return null;
    }


    public ResponseEntity<Address> updateEntity(Long aLong, Address entity) {
        return null;
    }


    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
