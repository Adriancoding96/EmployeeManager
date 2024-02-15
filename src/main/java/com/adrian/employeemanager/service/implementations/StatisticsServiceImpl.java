package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.DepartmentEmployeeCountDTO;
import com.adrian.employeemanager.dto.MonthlyEvaluationCountDTO;
import com.adrian.employeemanager.repository.DepartmentRepository;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.EvaluationRepository;
import com.adrian.employeemanager.service.interfaces.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EvaluationRepository evaluationRepository;

    @Autowired
    public StatisticsServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EvaluationRepository evaluationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Map<String, Long> getAllCounts() {
        long employeeCount = employeeRepository.count();
        long departmentCount = departmentRepository.count();
        long evaluationCount = evaluationRepository.count();

        Map<String, Long> counts = new HashMap<>();
        counts.put("employees", employeeCount);
        counts.put("departments", departmentCount);
        counts.put("evaluation", evaluationCount);
        return counts;
    }

    @Override
    public List<DepartmentEmployeeCountDTO> getEmployeeCountsByDepartment() {
        List<DepartmentEmployeeCountDTO> dtoList = departmentRepository.findEmployeeCountsByDepartment().stream()
                .map(projection -> new DepartmentEmployeeCountDTO(projection.getLabel(), projection.getValue()))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<MonthlyEvaluationCountDTO> getMonthlyEvaluationCounts() {
        List<MonthlyEvaluationCountDTO> monthlyCounts = evaluationRepository.findEvaluationCountsPerYearMonth();
        return monthlyCounts;
    }
}
