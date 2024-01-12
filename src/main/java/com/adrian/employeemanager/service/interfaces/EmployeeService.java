package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.EmployeeDTO;
import com.adrian.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployeesFromDepartment(Long id);

    Employee updateEmployee(EmployeeDTO employeeDTO, Long id);

    void deleteEmployee(Long id);
}
