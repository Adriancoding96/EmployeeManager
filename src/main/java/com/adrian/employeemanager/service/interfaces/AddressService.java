package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.AddressDTO;
import com.adrian.employeemanager.model.Address;

import java.util.List;

public interface AddressService {

    Address createAddressFromDTO(AddressDTO addressDTO);
    Address createAddress(Address address);
    List<Address> getAllAddresses();
}
