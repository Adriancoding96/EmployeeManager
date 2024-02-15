package com.adrian.employeemanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "work-days")
public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workDayId;

    private int totalHours;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "timesheet_id")
    @JsonBackReference("timesheet-workday")
    private Timesheet timesheet;

    @OneToMany(mappedBy = "workDay", fetch = FetchType.EAGER)
    @JsonManagedReference("workDay-work")
    private List<Work> workList;

    private LocalDateTime created;
    private LocalDateTime modified;


    public WorkDay(){

    }

    public WorkDay(Long workDayId, int totalHours, LocalDate date, Timesheet timesheet, List<Work> workList, LocalDateTime created, LocalDateTime modified) {
        this.workDayId = workDayId;
        this.totalHours = totalHours;
        this.date = date;
        this.timesheet = timesheet;
        this.workList = workList;
        this.created = created;
        this.modified = modified;
    }

    public Long getWorkDayId() {
        return workDayId;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public LocalDate getDate() {
        return date;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public List<Work> getWorkList() {
        return workList;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setWorkDayId(Long workDayId) {
        this.workDayId = workDayId;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "WorkDay{" +
                "workDayId=" + workDayId +
                ", totalHours=" + totalHours +
                ", date=" + date +
                ", timesheet=" + timesheet +
                ", workList=" + workList +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
