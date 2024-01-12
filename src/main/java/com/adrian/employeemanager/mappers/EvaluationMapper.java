package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.EvaluationDTO;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.Evaluation;
import com.adrian.employeemanager.model.Manager;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.ManagerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EvaluationMapper {

    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EvaluationMapper(ManagerRepository managerRepository, EmployeeRepository employeeRepository) {
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
    }

    public Evaluation toEvaluation(EvaluationDTO evaluationDTO){
        Evaluation evaluation = new Evaluation();

        Manager manager = managerRepository.findById(evaluationDTO.getManagerId())
                .orElseThrow(() -> new EntityNotFoundException("Manager with id: " + evaluationDTO.getManagerId() + " not found."));

        Employee employee = employeeRepository.findById(evaluationDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee with id: " + evaluationDTO.getEmployeeId() + " not found"));

        evaluation.setManager(manager);
        evaluation.setEmployee(employee);
        evaluation.setDateOfEvaluation(evaluationDTO.getDateOfEvaluation());

        return evaluation;
    }

    public Evaluation updateEvaluationFromDto(EvaluationDTO evaluationDTO, Evaluation evaluation){
        Manager manager = managerRepository.findById(evaluationDTO.getManagerId())
                .orElseThrow(() -> new EntityNotFoundException("Manager with id: " + evaluationDTO.getManagerId() + " not found."));

        Employee employee = employeeRepository.findById(evaluationDTO.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee with id: " + evaluationDTO.getEmployeeId() + " not found"));

        evaluation.setManager(manager);
        evaluation.setEmployee(employee);
        evaluation.setDateOfEvaluation(evaluationDTO.getDateOfEvaluation());

        return evaluation;
    }
}
