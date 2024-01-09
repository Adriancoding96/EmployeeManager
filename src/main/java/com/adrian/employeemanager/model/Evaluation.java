package com.adrian.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "evaluations")
public class Evaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluationId;

    @ManyToOne
    @JoinColumn(name = "mannager_id", nullable = false)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(nullable = false)
    private LocalDate dateOfEvaluation;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Evaluation() {
    }

    public Evaluation(Long evaluationId, Manager manager, Employee employee, LocalDate dateOfEvaluation, LocalDateTime created, LocalDateTime modified) {
        this.evaluationId = evaluationId;
        this.manager = manager;
        this.employee = employee;
        this.dateOfEvaluation = dateOfEvaluation;
        this.created = created;
        this.modified = modified;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public Manager getManager() {
        return manager;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getDateOfEvaluation() {
        return dateOfEvaluation;
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

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setDateOfEvaluation(LocalDate dateOfEvaluation) {
        this.dateOfEvaluation = dateOfEvaluation;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
