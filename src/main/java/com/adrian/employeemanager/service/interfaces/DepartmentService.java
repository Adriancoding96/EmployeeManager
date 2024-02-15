package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.DepartmentDTO;
import com.adrian.employeemanager.model.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(DepartmentDTO departmentDTO);
    List<Department> getAllDepartments();
}
