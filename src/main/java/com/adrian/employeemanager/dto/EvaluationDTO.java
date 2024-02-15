package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.Manager;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EvaluationDTO {

    private Long evaluationId;

    private Long managerId;

    private Long employeeId;

    private LocalDate dateOfEvaluation;

    private String comment;

    private LocalDateTime created;

    private LocalDateTime modified;

    public EvaluationDTO() {
    }

    public EvaluationDTO(Long evaluationId, Long managerId, Long employeeId, LocalDate dateOfEvaluation, String comment, LocalDateTime created, LocalDateTime modified) {
        this.evaluationId = evaluationId;
        this.managerId = managerId;
        this.employeeId = employeeId;
        this.dateOfEvaluation = dateOfEvaluation;
        this.comment = comment;
        this.created = created;
        this.modified = modified;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDateOfEvaluation() {
        return dateOfEvaluation;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setDateOfEvaluation(LocalDate dateOfEvaluation) {
        this.dateOfEvaluation = dateOfEvaluation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}

