package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.DTO.EmployeeDTO;
import com.adrian.employeemanager.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(EmployeeDTO employeeDTO, Long id);

    void deleteEmployee(Long id);
}
