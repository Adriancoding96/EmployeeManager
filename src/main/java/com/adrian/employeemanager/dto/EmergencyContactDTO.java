package com.adrian.employeemanager.dto;

import java.time.LocalDateTime;

public class EmergencyContactDTO {

    private Long emergencyContactId;
    private Long employeeId;
    private String name;
    private String email;
    private String phoneNumber;
    private AddressDTO addressDTO;

    public EmergencyContactDTO() {
    }

    public EmergencyContactDTO(Long emergencyContactId, Long employeeId, String name, String email, String phoneNumber, AddressDTO addressDTO) {
        this.emergencyContactId = emergencyContactId;
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressDTO = addressDTO;
    }

    public Long getEmergencyContactId() {
        return emergencyContactId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setEmergencyContactId(Long emergencyContactId) {
        this.emergencyContactId = emergencyContactId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}

