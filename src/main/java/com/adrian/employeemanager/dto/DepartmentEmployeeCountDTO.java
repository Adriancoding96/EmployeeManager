package com.adrian.employeemanager.dto;

public class DepartmentEmployeeCountDTO {
    private String label;
    private Long value;

    public DepartmentEmployeeCountDTO() {

    }

    public DepartmentEmployeeCountDTO(String label, Long value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Long getValue() {
        return value;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
