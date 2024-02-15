package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.enums.StatusEnum;

public class CertificationDTO {

    private Long certificationId;
    private Long employeeId;
    private String name;
    private String organization;
    private StatusEnum status;


    public CertificationDTO() {
    }

    public CertificationDTO(Long certificationId, Long employeeId, String name, String organization, StatusEnum status) {
        this.certificationId = certificationId;
        this.employeeId = employeeId;
        this.name = name;
        this.organization = organization;
        this.status = status;
    }

    public Long getCertificationId() {
        return certificationId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
