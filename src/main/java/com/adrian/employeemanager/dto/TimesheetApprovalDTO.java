package com.adrian.employeemanager.dto;

public class TimesheetApprovalDTO {

    private Long timesheetId;
    private Boolean approved;

    public TimesheetApprovalDTO(){

    }

    public TimesheetApprovalDTO(Long timesheetId, Boolean approved) {
        this.timesheetId = timesheetId;
        this.approved = approved;
    }

    public Long getTimesheetId() {
        return timesheetId;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setTimesheetId(Long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
