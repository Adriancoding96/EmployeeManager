package com.adrian.employeemanager.enums;

public enum MonthEnum {
    JANUARY("January", 1),
    FEBRUARY("February", 2),
    MARCH("March", 3),
    APRIL("April", 4),
    MAY("May", 5),
    JUNE("June", 6),
    JULY("July", 7),
    AUGUST("August", 8),
    SEPTEMBER("September", 9),
    OKTOBER("Oktober", 10),
    NOVEMBER("November", 11),
    DECEMBER("December", 12);

    private final String description;
    private final int number;

    MonthEnum(String description, int number) {
        this.description = description;
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }

    public static MonthEnum of(int month) {
        for (MonthEnum me : values()) {
            if (me.getNumber() == month) {
                return me;
            }
        }
        throw new IllegalArgumentException("Invalid month number: " + month);
    }
}
