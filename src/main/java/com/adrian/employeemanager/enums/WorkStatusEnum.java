package com.adrian.employeemanager.enums;

public enum WorkStatusEnum {
    INOFFICE("In office work"),
    REMOTE("Remote work"),
    HOLIDAY("Holiday"),
    EMERGENCY("Emergency"),
    TIMEOFF("Booked time off work");

    private final String description;

    WorkStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
