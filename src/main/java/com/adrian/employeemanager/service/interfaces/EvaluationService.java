package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.EvaluationDTO;
import com.adrian.employeemanager.model.Evaluation;

import java.util.List;

public interface EvaluationService {
    Evaluation createEvaluation(EvaluationDTO evaluationDTO);
    Evaluation getEvaluationById(Long id);
    List<EvaluationDTO> getAllEvaluations();
    List<EvaluationDTO> getAllEvaluationsByYear(int year, Long employeeId);
    Evaluation updateEvaluation(Long id, EvaluationDTO evaluationDTO);
    void deleteEvaluation(Long id);
}
