package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.dto.EvaluationDTO;
import com.adrian.employeemanager.model.Evaluation;
import com.adrian.employeemanager.service.interfaces.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/evaluations")
    public ResponseEntity<Evaluation> createEntity(@RequestBody EvaluationDTO evaluationDTO) {
        Evaluation evaluation = evaluationService.createEvaluation(evaluationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluation);
    }

    @GetMapping("/evaluations/{id}")
    public ResponseEntity<Evaluation> findById(@PathVariable Long id) {
        Evaluation evaluation = evaluationService.getEvaluationById(id);
        return ResponseEntity.ok(evaluation);
    }

    @GetMapping("/evaluations")
    public ResponseEntity<List<EvaluationDTO>> findAll() {
        List<EvaluationDTO> evaluations = evaluationService.getAllEvaluations();
        return ResponseEntity.ok(evaluations);
    }

    @GetMapping("/evaluations/{employeeId}/year/{year}")
    public ResponseEntity<List<EvaluationDTO>> getEvaluationsByYearAndEmployeeId(@PathVariable Long employeeId, @PathVariable int year) {
        List<EvaluationDTO> evaluations = evaluationService.getAllEvaluationsByYear(year, employeeId);
        return ResponseEntity.ok(evaluations);
    }

    @PostMapping("/evaluations/{id}")
    public ResponseEntity<Evaluation> updateEntity(Long id, EvaluationDTO evaluationDTO) {
        Evaluation evaluation = evaluationService.updateEvaluation(id, evaluationDTO);
        return ResponseEntity.ok(evaluation);
    }

    @DeleteMapping("/evaluations/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
