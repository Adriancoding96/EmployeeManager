package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.PastEmploymentDTO;
import com.adrian.employeemanager.mappers.PersistanceMapper;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.PastEmployment;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.PastEmploymentRepository;
import com.adrian.employeemanager.service.interfaces.PastEmploymentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PastEmploymentServiceImpl implements PastEmploymentService {

    private final PastEmploymentRepository pastEmploymentRepository;
    private final EmployeeRepository employeeRepository;

    private final PersistanceMapper persistanceMapper;

    @Autowired
    public PastEmploymentServiceImpl(PastEmploymentRepository pastEmploymentRepository, EmployeeRepository employeeRepository, PersistanceMapper persistanceMapper) {
        this.pastEmploymentRepository = pastEmploymentRepository;
        this.employeeRepository = employeeRepository;
        this.persistanceMapper = persistanceMapper;
    }

    @Override
    public PastEmployment createPastEmployment(PastEmploymentDTO pastEmploymentDTO) {
        PastEmployment pastEmployment = persistanceMapper.DTOToPastEmployment(pastEmploymentDTO);
        pastEmployment.setCreated(LocalDateTime.now());
        pastEmployment.setModified(LocalDateTime.now());
        return pastEmploymentRepository.save(pastEmployment);
    }

    @Override
    public List<PastEmployment> getAllPastEmployments() {
        return pastEmploymentRepository.findAll();
    }
}
