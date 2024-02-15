package com.adrian.employeemanager.dto;

public class PastEmploymentDTO {

    private Long pastemploymentId;
    private Long employeeId;
    private String information;

    public PastEmploymentDTO() {
    }

    public PastEmploymentDTO(Long pastemploymentId, Long employeeId, String information) {
        this.pastemploymentId = pastemploymentId;
        this.employeeId = employeeId;
        this.information = information;
    }

    public Long getPastemploymentId() {
        return pastemploymentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getInformation() {
        return information;
    }

    public void setPastemploymentId(Long pastemploymentId) {
        this.pastemploymentId = pastemploymentId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
