package com.adrian.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "manager_id", nullable = false)
    @JsonIgnore
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference("employee-evaluation")
    private Employee employee;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDate dateOfEvaluation;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Evaluation() {
    }

    public Evaluation(Long evaluationId, Manager manager, Employee employee, String comment, LocalDate dateOfEvaluation, LocalDateTime created, LocalDateTime modified) {
        this.evaluationId = evaluationId;
        this.manager = manager;
        this.employee = employee;
        this.comment = comment;
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

    public String getComment() {
        return comment;
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

    public void setComment(String comment) {
        this.comment = comment;
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
