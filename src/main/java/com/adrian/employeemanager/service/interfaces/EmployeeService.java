package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.EmployeeDTO;
import com.adrian.employeemanager.dto.EmployeeSelectionDTO;
import com.adrian.employeemanager.dto.NewEmployeeDTO;
import com.adrian.employeemanager.enums.MonthEnum;
import com.adrian.employeemanager.model.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(NewEmployeeDTO newEmployeeDTO);
    Employee updateEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployeesFromDepartment(Long id);

    Employee updateEmployee(EmployeeDTO employeeDTO, Long id);

    void deleteEmployee(Long id);

    List<Employee> findEmployeesWithoutTimesheetForMonthAndYear(MonthEnum monthEnum, int year);

    List<EmployeeSelectionDTO> getAllEmployeesAsSelectionDTO();


}
