package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.model.Manager;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ManagerController implements EntityController<Manager, Long> {
    @Override
    public ResponseEntity<Manager> createEntity(Manager entity) {
        return null;
    }

    @Override
    public ResponseEntity<Manager> findById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Manager> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Manager>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<Manager>> findAllByEmployeeId(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Manager> updateEntity(Long aLong, Manager entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
