package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserController implements EntityController<User, Long> {
    @Override
    public ResponseEntity<User> createEntity(User entity) {
        return null;
    }

    @Override
    public ResponseEntity<User> findById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<User> updateEntity(Long aLong, User entity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
