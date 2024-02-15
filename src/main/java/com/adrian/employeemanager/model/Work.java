package com.adrian.employeemanager.model;

import com.adrian.employeemanager.enums.WorkEnum;
import com.adrian.employeemanager.enums.WorkStatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workId;

    @ManyToOne
    @JoinColumn(name = "workday_id")
    @JsonBackReference("workDay-work")
    private WorkDay workDay;
    private int hours;
    private WorkEnum workType;
    private WorkStatusEnum workStatusEnum;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Work() {

    }

    public Work(Long workId, WorkDay workDay, int hours, WorkEnum workType, WorkStatusEnum workStatusEnum, String description, LocalDateTime created, LocalDateTime modified) {
        this.workId = workId;
        this.workDay = workDay;
        this.hours = hours;
        this.workType = workType;
        this.workStatusEnum = workStatusEnum;
        this.description = description;
        this.created = created;
        this.modified = modified;
    }

    public Long getWorkId() {
        return workId;
    }

    public WorkDay getWorkDay() {
        return workDay;
    }

    public int getHours() {
        return hours;
    }

    public WorkEnum getWorkType() {
        return workType;
    }

    public WorkStatusEnum getWorkStatusEnum() {
        return workStatusEnum;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public void setWorkDay(WorkDay workDay) {
        this.workDay = workDay;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setWorkType(WorkEnum workType) {
        this.workType = workType;
    }

    public void setWorkStatusEnum(WorkStatusEnum workStatusEnum) {
        this.workStatusEnum = workStatusEnum;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
