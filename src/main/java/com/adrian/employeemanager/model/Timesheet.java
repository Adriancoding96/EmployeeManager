package com.adrian.employeemanager.model;

import com.adrian.employeemanager.enums.MonthEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "timesheets")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeSheetId;

    @OneToMany(mappedBy = "timesheet")
    @JsonManagedReference("timesheet-workday")
    private List<WorkDay> workDays;



    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference("employee-timesheet")
    private Employee employee;

    private MonthEnum monthEnum;

    private int timesheetYear;

    private boolean approved;

    private LocalDateTime created;

    private LocalDateTime modified;

    public Timesheet(){

    }

    public Timesheet(Long timeSheetId, List<WorkDay> workDays, Employee employee, MonthEnum monthEnum, int timesheetYear, boolean approved, LocalDateTime created, LocalDateTime modified) {
        this.timeSheetId = timeSheetId;
        this.workDays = workDays;
        this.employee = employee;
        this.monthEnum = monthEnum;
        this.timesheetYear = timesheetYear;
        this.approved = approved;
        this.created = created;
        this.modified = modified;
    }

    public Long getTimeSheetId() {
        return timeSheetId;
    }

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public Employee getEmployee() {
        return employee;
    }

    public MonthEnum getMonthEnum() {
        return monthEnum;
    }

    public int getTimesheetYear() {
        return timesheetYear;
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

    public void setTimeSheetId(Long timeSheetId) {
        this.timeSheetId = timeSheetId;
    }

    public void setWorkDays(List<WorkDay> workDays) {
        this.workDays = workDays;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setMonthEnum(MonthEnum monthEnum) {
        this.monthEnum = monthEnum;
    }

    public void setTimesheetYear(int timesheetYear) {
        this.timesheetYear = timesheetYear;
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

    @Override
    public String toString() {
        return "Timesheet{" +
                "timeSheetId=" + timeSheetId +
                ", approved=" + approved
                ;
    }
}
