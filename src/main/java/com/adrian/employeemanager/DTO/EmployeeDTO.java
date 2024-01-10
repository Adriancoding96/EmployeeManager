package com.adrian.employeemanager.DTO;


import com.adrian.employeemanager.enums.PositionEnum;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeDTO {

    private Long employeeId;

    private String employeeName;

    private String employeeEmail;

    private String employeePhone;

    private PositionEnum position;

    private Long addressId;

    private Long departmentId;

    private List<Long> evaluations;

    private List<Long> pastEmployments;

    private List<Long> educations;

    private List<Long> emergencyContacts;

    private List<Long> notes;

    private List<Long> certifications;

    private LocalDateTime created;
    private LocalDateTime modified;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String employeeName, String employeeEmail, String employeePhone, PositionEnum position, Long addressId, Long departmentId, List<Long> evaluations, List<Long> pastEmployments, List<Long> educations, List<Long> emergencyContacts, List<Long> notes, List<Long> certifications, LocalDateTime created, LocalDateTime modified) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.position = position;
        this.addressId = addressId;
        this.departmentId = departmentId;
        this.evaluations = evaluations;
        this.pastEmployments = pastEmployments;
        this.educations = educations;
        this.emergencyContacts = emergencyContacts;
        this.notes = notes;
        this.certifications = certifications;
        this.created = created;
        this.modified = modified;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public Long getAddressId() {
        return addressId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public List<Long> getEvaluations() {
        return evaluations;
    }

    public List<Long> getPastEmployments() {
        return pastEmployments;
    }

    public List<Long> getEducations() {
        return educations;
    }

    public List<Long> getEmergencyContacts() {
        return emergencyContacts;
    }

    public List<Long> getNotes() {
        return notes;
    }

    public List<Long> getCertifications() {
        return certifications;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setEvaluations(List<Long> evaluations) {
        this.evaluations = evaluations;
    }

    public void setPastEmployments(List<Long> pastEmployments) {
        this.pastEmployments = pastEmployments;
    }

    public void setEducations(List<Long> educations) {
        this.educations = educations;
    }

    public void setEmergencyContacts(List<Long> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public void setNotes(List<Long> notes) {
        this.notes = notes;
    }

    public void setCertifications(List<Long> certifications) {
        this.certifications = certifications;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
