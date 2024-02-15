package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.AddressDTO;
import com.adrian.employeemanager.mappers.AddressMapper;
import com.adrian.employeemanager.mappers.PersistanceMapper;
import com.adrian.employeemanager.model.Address;
import com.adrian.employeemanager.repository.AddressRepository;
import com.adrian.employeemanager.service.interfaces.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository,  AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Address createAddressFromDTO(AddressDTO addressDTO) {
        Address address = addressMapper.DTOToAddress(addressDTO);
        System.out.println(address.toString());
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        return addressRepository.save(address);
    }

    @Override
    public Address createAddress(Address address) {
        address.setCreated(LocalDateTime.now());
        address.setModified(LocalDateTime.now());
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
