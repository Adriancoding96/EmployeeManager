package com.adrian.employeemanager.model;

import com.adrian.employeemanager.enums.EducationEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "educations")
public class Education  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    @JsonBackReference
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EducationEnum educationType;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Education() {
    }

    public Education(Long educationId, Employee employee, EducationEnum educationType, String degree, LocalDate startDate, LocalDate endDate, LocalDateTime created, LocalDateTime modified) {
        this.educationId = educationId;
        this.employee = employee;
        this.educationType = educationType;
        this.degree = degree;
        this.startDate = startDate;
        this.endDate = endDate;
        this.created = created;
        this.modified = modified;
    }

    public Long getEducationId() {
        return educationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EducationEnum getEducationType() {
        return educationType;
    }

    public String getDegree() {
        return degree;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setEducationId(Long educationId) {
        this.educationId = educationId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEducationType(EducationEnum educationType) {
        this.educationType = educationType;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
