package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.DTO.EmployeeDTO;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO, Long id) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
