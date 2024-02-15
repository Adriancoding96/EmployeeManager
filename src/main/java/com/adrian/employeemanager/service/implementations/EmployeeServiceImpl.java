package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.EmployeeDTO;
import com.adrian.employeemanager.dto.EmployeeSelectionDTO;
import com.adrian.employeemanager.dto.NewEmployeeDTO;
import com.adrian.employeemanager.enums.MonthEnum;
import com.adrian.employeemanager.enums.RoleEnum;
import com.adrian.employeemanager.mappers.EmployeeMapper;
import com.adrian.employeemanager.model.Address;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.User;
import com.adrian.employeemanager.repository.AddressRepository;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.UserRepository;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import com.adrian.employeemanager.util.Utils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final UserRepository userRepository;
    private final  EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final EmployeeMapper employeeMapper;
    private final Utils utils;

    @Autowired
    public EmployeeServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository, AddressRepository addressRepository, EmployeeMapper employeeMapper, Utils utils) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.employeeMapper = employeeMapper;
        this.utils = utils;
    }

    @Override
    @Transactional
    public Employee createEmployee(NewEmployeeDTO newEmployeeDTO) {
        Employee employee = employeeMapper.newEmployeFromDTO(newEmployeeDTO);
        employee.setCreated(LocalDateTime.now());
        employee.setModified(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO, null);
        employee.setCreated(LocalDateTime.now());
        employee.setModified(LocalDateTime.now());
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
    public List<Employee> getAllEmployeesFromDepartment(Long id) {
        return employeeRepository.findByDepartmentDepartmentId(id);
    }

    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO, Long id) {
        Employee updatedEmployee = employeeMapper.toEmployee(employeeDTO, id);
        updatedEmployee.setModified(LocalDateTime.now());
        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with id: " + id + " not found.");
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeesWithoutTimesheetForMonthAndYear(MonthEnum monthEnum, int year) {
        return employeeRepository.findEmployeesWithoutTimesheetForMonthAndYear(monthEnum, year);
    }

    @Override
    public List<EmployeeSelectionDTO> getAllEmployeesAsSelectionDTO() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toSelectionDTO).collect(Collectors.toList());
    }
}
