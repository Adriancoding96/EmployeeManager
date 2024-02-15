package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Education;
import com.adrian.employeemanager.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    List<Timesheet> findByEmployeeEmployeeId(Long employeeId);
}
