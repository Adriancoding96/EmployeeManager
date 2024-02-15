package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.enums.RoleEnum;

public class NewEmployeeDTO {

    private String username;
    private String password;
    private RoleEnum role = RoleEnum.EMPLOYEE;
    private String name;
    private String email;
    private String phoneNumber;
    private String position;
    private Long departmentId;
    private NewAddressDTO address;

    public NewEmployeeDTO() {
    }

    public NewEmployeeDTO(String username, String password, RoleEnum role, String name, String email, String phoneNumber, String position, Long departmentId, NewAddressDTO address) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.departmentId = departmentId;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public RoleEnum getRole() {
        return role;
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

    public String getPosition() {
        return position;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public NewAddressDTO getAddress() {
        return address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
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

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setAddress(NewAddressDTO address) {
        this.address = address;
    }
}
