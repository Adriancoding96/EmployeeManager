package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.enums.WorkEnum;
import com.adrian.employeemanager.enums.WorkStatusEnum;

import java.time.LocalDateTime;

public class WorkDTO {

    private Long workId;
    private Long workDayId;
    private int hours;
    private WorkEnum workEnum;
    private WorkStatusEnum workStatusEnum;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;

    public WorkDTO(){

    }

    public WorkDTO(Long workId, Long workDayId, int hours, WorkEnum workEnum, WorkStatusEnum workStatusEnum, String description, LocalDateTime created, LocalDateTime modified) {
        this.workId = workId;
        this.workDayId = workDayId;
        this.hours = hours;
        this.workEnum = workEnum;
        this.workStatusEnum = workStatusEnum;
        this.description = description;
        this.created = created;
        this.modified = modified;
    }

    public Long getWorkId() {
        return workId;
    }

    public Long getWorkDayId() {
        return workDayId;
    }

    public int getHours() {
        return hours;
    }

    public WorkEnum getWorkEnum() {
        return workEnum;
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

    public void setWorkDayId(Long workDayId) {
        this.workDayId = workDayId;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setWorkEnum(WorkEnum workEnum) {
        this.workEnum = workEnum;
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
