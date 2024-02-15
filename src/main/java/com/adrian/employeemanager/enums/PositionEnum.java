package com.adrian.employeemanager.enums;

public enum PositionEnum {
    Junior_Developer("Junior Developer"),
    Senior_Developer("Senior Developer"),
    Tech_Lead("Tech Lead");

    private final String description;

    PositionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
