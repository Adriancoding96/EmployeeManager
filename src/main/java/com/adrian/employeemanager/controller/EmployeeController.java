package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.DTO.EmployeeDTO;
import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;


    public ResponseEntity<Employee> createEntity(EmployeeDTO entity) {
        return null;
    }

    public ResponseEntity<Employee> findById(Long aLong) {
        return null;
    }

    public ResponseEntity<List<Employee>> findAll() {
        return null;
    }


    public ResponseEntity<Employee> updateEntity(Long aLong, EmployeeDTO entity) {
        return null;
    }

    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
