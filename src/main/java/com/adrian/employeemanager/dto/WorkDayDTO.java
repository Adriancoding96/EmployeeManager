package com.adrian.employeemanager.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class WorkDayDTO {
    private Long workDayId;
    private Long timesheetId;
    private int totalHours;
    private LocalDate date;
    private LocalDateTime created;
    private LocalDateTime modified;
    private List<WorkDTO> workDTOS;

    public WorkDayDTO(){

    }

    public WorkDayDTO(Long workDayId, Long timesheetId, int totalHours, LocalDate date, LocalDateTime created, LocalDateTime modified, List<WorkDTO> workDTOS) {
        this.workDayId = workDayId;
        this.timesheetId = timesheetId;
        this.totalHours = totalHours;
        this.date = date;
        this.created = created;
        this.modified = modified;
        this.workDTOS = workDTOS;
    }

    public Long getWorkDayId() {
        return workDayId;
    }

    public Long getTimesheetId() {
        return timesheetId;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public List<WorkDTO> getWorkDTOS() {
        return workDTOS;
    }

    public void setWorkDayId(Long workDayId) {
        this.workDayId = workDayId;
    }

    public void setTimesheetId(Long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public void setWorkDTOS(List<WorkDTO> workDTOS) {
        this.workDTOS = workDTOS;
    }
}
