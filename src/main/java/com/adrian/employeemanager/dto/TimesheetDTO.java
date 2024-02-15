package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.enums.MonthEnum;

import java.time.LocalDateTime;
import java.util.List;

public class TimesheetDTO {
    private Long timeSheetId;
    private Long employeeId;
    private MonthEnum monthEnum;
    private int year;
    private boolean approved;
    private LocalDateTime created;
    private LocalDateTime modified;
    private List<WorkDayDTO> workDays;

    public TimesheetDTO() {

    }

    public TimesheetDTO(Long timeSheetId, Long employeeId, MonthEnum monthEnum, int year, boolean approved, LocalDateTime created, LocalDateTime modified, List<WorkDayDTO> workDays) {
        this.timeSheetId = timeSheetId;
        this.employeeId = employeeId;
        this.monthEnum = monthEnum;
        this.year = year;
        this.approved = approved;
        this.created = created;
        this.modified = modified;
        this.workDays = workDays;
    }

    public Long getTimeSheetId() {
        return timeSheetId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public MonthEnum getMonthEnum() {
        return monthEnum;
    }

    public int getYear() {
        return year;
    }

    public boolean isApproved() {
        return approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public List<WorkDayDTO> getWorkDays() {
        return workDays;
    }

    public void setTimeSheetId(Long timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setMonthEnum(MonthEnum monthEnum) {
        this.monthEnum = monthEnum;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public void setWorkDays(List<WorkDayDTO> workDays) {
        this.workDays = workDays;
    }
}
