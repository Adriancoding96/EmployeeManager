package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.DepartmentDTO;
import com.adrian.employeemanager.model.Department;
import com.adrian.employeemanager.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/department")
public class DepartmentController{

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping
    public ResponseEntity<Department> createEntity(@RequestBody DepartmentDTO departmentDTO) {
        Department createdDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }


    public ResponseEntity<Department> findById(Long aLong) {
        return null;
    }


    public ResponseEntity<Department> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    public ResponseEntity<List<Department>> findAllByEmployeeId(Long aLong) {
        return null;
    }


    public ResponseEntity<Department> updateEntity(Long aLong, Department entity) {
        return null;
    }


    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
