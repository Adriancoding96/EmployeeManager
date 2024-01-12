package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.dto.EmployeeDTO;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEntity(@RequestBody EmployeeDTO employeeDTO) {
        Employee createdEmployee = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/department/{id}")
    public ResponseEntity<List<Employee>> findAllByDepartment(@PathVariable Long id){
        List<Employee> employees = employeeService.getAllEmployeesFromDepartment(id);
        return ResponseEntity.ok(employees);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEntity(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee updatedEmployee = employeeService.updateEmployee(employeeDTO, id);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
