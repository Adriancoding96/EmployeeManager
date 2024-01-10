package com.adrian.employeemanager.controller.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EntityController<T, ID> {

    ResponseEntity<T> createEntity(T entity);

    ResponseEntity<T> findById(ID id);

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> updateEntity(ID id, T entity);

    ResponseEntity<Void> deleteEntity(ID id);
}
