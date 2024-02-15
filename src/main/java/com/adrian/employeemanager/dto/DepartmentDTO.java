package com.adrian.employeemanager.dto;

import com.adrian.employeemanager.model.Address;
import com.adrian.employeemanager.model.Employee;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentDTO {

    private Long departmentId;
    private String departmentName;
    private AddressDTO addressDTO;
    private LocalDateTime created;
    private LocalDateTime modified;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long departmentId, String departmentName, AddressDTO addressDTO, LocalDateTime created, LocalDateTime modified) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.addressDTO = addressDTO;
        this.created = created;
        this.modified = modified;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
