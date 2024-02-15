package com.adrian.employeemanager.dto;

public class EmployeeSelectionDTO {

    private Long employeeId;

    private String employeeName;

    public EmployeeSelectionDTO() {
    }

    public EmployeeSelectionDTO(Long employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
