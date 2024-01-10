package com.adrian.employeemanager.mappers.interfaces;

@FunctionalInterface
public interface UpdateAction<T, U> {
    T update(U dtoId);
}
