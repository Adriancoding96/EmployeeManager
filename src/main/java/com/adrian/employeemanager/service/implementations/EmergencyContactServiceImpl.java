package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.EmergencyContactDTO;
import com.adrian.employeemanager.mappers.PersistanceMapper;
import com.adrian.employeemanager.model.Address;
import com.adrian.employeemanager.model.EmergencyContact;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.repository.AddressRepository;
import com.adrian.employeemanager.repository.EmergencyContactRepository;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.service.interfaces.AddressService;
import com.adrian.employeemanager.service.interfaces.EmergencyContactService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmergencyContactServiceImpl implements EmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;
    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;

    private final PersistanceMapper persistanceMapper;

    @Autowired
    public EmergencyContactServiceImpl(EmergencyContactRepository emergencyContactRepository, AddressRepository addressRepository, EmployeeRepository employeeRepository, PersistanceMapper persistanceMapper) {
        this.emergencyContactRepository = emergencyContactRepository;
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
        this.persistanceMapper = persistanceMapper;
    }

    @Override
    public EmergencyContact createEmergencyContact(EmergencyContactDTO emergencyContactDTO) {
        EmergencyContact emergencyContact = persistanceMapper.DTOtoEmergencyContact(emergencyContactDTO);
        emergencyContact.setCreated(LocalDateTime.now());
        emergencyContact.setModified(LocalDateTime.now());
        return emergencyContactRepository.save(emergencyContact);
    }

    @Override
    public List<EmergencyContact> getAllEmergencyContacts() {
        return emergencyContactRepository.findAll();
    }
}
