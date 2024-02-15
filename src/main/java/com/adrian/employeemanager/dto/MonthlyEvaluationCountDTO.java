package com.adrian.employeemanager.dto;

public class MonthlyEvaluationCountDTO {

    private int year;
    private int month;
    private Long count;

    public MonthlyEvaluationCountDTO(int year, int month, Long count) {
        this.year = year;
        this.month = month;
        this.count = count;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public Long getCount() {
        return count;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
