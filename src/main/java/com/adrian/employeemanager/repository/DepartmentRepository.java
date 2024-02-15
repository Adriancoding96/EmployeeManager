package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.dto.DepartmentEmployeeCountDTO;
import com.adrian.employeemanager.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DepartmentRepository  extends JpaRepository<Department, Long> {
        @Query("SELECT new com.adrian.employeemanager.dto.DepartmentEmployeeCountDTO(d.departmentName, COUNT(e)) FROM Department d JOIN d.employees e GROUP BY d.departmentName")
        List<DepartmentEmployeeCountDTO> findEmployeeCountsByDepartment();


}
