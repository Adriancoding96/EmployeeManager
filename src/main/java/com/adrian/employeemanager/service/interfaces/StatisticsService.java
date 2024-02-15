package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.DepartmentEmployeeCountDTO;
import com.adrian.employeemanager.dto.MonthlyEvaluationCountDTO;

import java.util.List;
import java.util.Map;

public interface StatisticsService {

    Map<String, Long> getAllCounts();

    List<DepartmentEmployeeCountDTO> getEmployeeCountsByDepartment();

    List<MonthlyEvaluationCountDTO> getMonthlyEvaluationCounts();
}
