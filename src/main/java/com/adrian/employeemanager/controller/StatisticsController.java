package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.dto.DepartmentEmployeeCountDTO;
import com.adrian.employeemanager.dto.MonthlyEvaluationCountDTO;
import com.adrian.employeemanager.repository.DepartmentRepository;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.EvaluationRepository;
import com.adrian.employeemanager.service.interfaces.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/stats")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/counts")
    public ResponseEntity<Map<String, Long>> getCounts() {
        Map<String, Long> counts = statisticsService.getAllCounts();
        return ResponseEntity.ok(counts);
    }

    @GetMapping("/department/employees")
    public ResponseEntity<List<DepartmentEmployeeCountDTO>> getEmployeeCountsByDepartment() {
        List<DepartmentEmployeeCountDTO> dtoList = statisticsService.getEmployeeCountsByDepartment();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/evaluations/monthly")
    public ResponseEntity<List<MonthlyEvaluationCountDTO>> getMonthlyEvaluationCounts() {
        List<MonthlyEvaluationCountDTO> monthlyCounts = statisticsService.getMonthlyEvaluationCounts();
        return ResponseEntity.ok(monthlyCounts);
    }

}
