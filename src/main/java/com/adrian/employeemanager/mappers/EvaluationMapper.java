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

    public EvaluationDTO toDTO(Evaluation evaluation) {
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setEvaluationId(evaluation.getEvaluationId());
        evaluationDTO.setManagerId(evaluation.getManager().getManagerId());
        evaluationDTO.setEmployeeId(evaluation.getEmployee().getEmployeeId());
        evaluationDTO.setComment(evaluation.getComment());
        evaluationDTO.setDateOfEvaluation(evaluation.getDateOfEvaluation());
        evaluationDTO.setCreated(evaluation.getCreated());
        evaluationDTO.setModified(evaluation.getModified());
        return evaluationDTO;
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
        evaluation.setComment(evaluationDTO.getComment());

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
