package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.AddressDTO;
import com.adrian.employeemanager.model.Address;
import com.adrian.employeemanager.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {


    public Address DTOToAddress(AddressDTO addressDTO) {
        Address address = new Address();
        if(addressDTO.getAddressId() != null) {
            address.setAddressId(addressDTO.getAddressId());
        }

        address.setCity(addressDTO.getCity());
        address.setStreetName(addressDTO.getStreetName());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setApartmentNumber(addressDTO.getApartmentNumber());
        address.setApartmentFloor(addressDTO.getApartmentFloor());
        return address;
    }
}
