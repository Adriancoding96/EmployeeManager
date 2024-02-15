package com.adrian.employeemanager.enums;

public enum WorkEnum {
    FRONTEND("Frontend"),
    BACKEND("Backend"),
    DESIGN("Design"),
    DOCUMENTATION("Documentation"),
    TESTING("Testing"),
    ABSENT("Absent");

    private final String description;

    WorkEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
