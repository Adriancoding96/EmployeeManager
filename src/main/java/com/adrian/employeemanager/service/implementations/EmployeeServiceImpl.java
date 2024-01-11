package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.DTO.EmployeeDTO;
import com.adrian.employeemanager.mappers.EmployeeMapper;
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
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO, null);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee with id: " + id + " not found."));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO, Long id) {
        Employee updatedEmployee = employeeMapper.toEmployee(employeeDTO, id);
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with id: " + id + " not found.");
        }
        employeeRepository.deleteById(id);
    }
}
