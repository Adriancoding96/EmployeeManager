package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.enums.EducationEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EducationDTO {

    private Long educationId;
    private Long employeeId;
    private EducationEnum educationType;
    private String degree;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime created;
    private LocalDateTime modified;

    public EducationDTO() {
    }

    public EducationDTO(Long educationId, Long employeeId, EducationEnum educationType, String degree, LocalDate startDate, LocalDate endDate, LocalDateTime created, LocalDateTime modified) {
        this.educationId = educationId;
        this.employeeId = employeeId;
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

    public Long getEmployeeId() {
        return employeeId;
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

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

