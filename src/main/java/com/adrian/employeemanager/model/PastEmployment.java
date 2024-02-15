package com.adrian.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "past_employment")
public class PastEmployment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employmentHistoryId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    @JsonBackReference
    private Employee employee;

    @Column(nullable = false)
    private String information;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public PastEmployment() {
    }

    public PastEmployment(Long employmentHistoryId, Employee employee, String information, LocalDateTime created, LocalDateTime modified) {
        this.employmentHistoryId = employmentHistoryId;
        this.employee = employee;
        this.information = information;
        this.created = created;
        this.modified = modified;
    }

    public Long getEmploymentHistoryId() {
        return employmentHistoryId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getInformation() {
        return information;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setEmploymentHistoryId(Long employmentHistoryId) {
        this.employmentHistoryId = employmentHistoryId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
