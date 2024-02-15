package com.adrian.employeemanager.model;

import com.adrian.employeemanager.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "certifications")
public class Certification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference
    private Employee employee;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organization;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    public Certification() {
    }

    public Certification(Long certificationId, Employee employee, String name, String organization, StatusEnum status, LocalDateTime created, LocalDateTime modified) {
        this.certificationId = certificationId;
        this.employee = employee;
        this.name = name;
        this.organization = organization;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public Long getCertificationId() {
        return certificationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
