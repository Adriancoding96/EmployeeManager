package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.DepartmentDTO;
import com.adrian.employeemanager.mappers.PersistanceMapper;
import com.adrian.employeemanager.model.Department;
import com.adrian.employeemanager.repository.DepartmentRepository;
import com.adrian.employeemanager.service.interfaces.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final PersistanceMapper persistanceMapper;


    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, PersistanceMapper persistanceMapper) {
        this.departmentRepository = departmentRepository;
        this.persistanceMapper = persistanceMapper;
    }

    @Override
    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = persistanceMapper.DTOToDepartment(departmentDTO);
        department.setCreated(LocalDateTime.now());
        department.setModified(LocalDateTime.now());
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
