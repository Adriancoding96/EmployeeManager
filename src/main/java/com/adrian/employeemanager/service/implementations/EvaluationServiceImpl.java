package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.EvaluationDTO;
import com.adrian.employeemanager.mappers.EvaluationMapper;
import com.adrian.employeemanager.model.Evaluation;
import com.adrian.employeemanager.repository.EvaluationRepository;
import com.adrian.employeemanager.service.interfaces.EvaluationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final EvaluationMapper evaluationMapper;

    @Autowired
    public EvaluationServiceImpl(EvaluationRepository evaluationRepository, EvaluationMapper evaluationMapper) {
        this.evaluationRepository = evaluationRepository;
        this.evaluationMapper = evaluationMapper;
    }

    @Override
    public Evaluation createEvaluation(EvaluationDTO evaluationDTO) {
        Evaluation evaluation = evaluationMapper.toEvaluation(evaluationDTO);
        evaluation.setCreated(LocalDateTime.now());
        evaluation.setModified(LocalDateTime.now());
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evaluation with id: " + id + " not found."));
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public Evaluation updateEvaluation(Long id, EvaluationDTO evaluationDTO) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evaluation with id: " + id + " not found."));

        evaluationMapper.updateEvaluationFromDto(evaluationDTO, evaluation);
        evaluation.setModified(LocalDateTime.now());

        return null;
    }

    @Override
    public void deleteEvaluation(Long id) {
        if (!evaluationRepository.existsById(id)) {
            throw new EntityNotFoundException("Evaluation not found with id: " + id);
        }
        evaluationRepository.deleteById(id);
    }
}
