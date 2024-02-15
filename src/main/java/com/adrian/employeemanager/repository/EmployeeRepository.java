package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.enums.MonthEnum;
import com.adrian.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE NOT EXISTS (" +
            "SELECT t FROM Timesheet t WHERE t.employee = e AND t.monthEnum = :monthEnum AND t.timesheetYear = :year)")
    List<Employee> findEmployeesWithoutTimesheetForMonthAndYear(@Param("monthEnum") MonthEnum monthEnum, @Param("year") int year);
}
