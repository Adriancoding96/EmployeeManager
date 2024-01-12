package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.model.User;
import com.adrian.employeemanager.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController implements EntityController<User, Long> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/users")
    public ResponseEntity<User> createEntity(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @Override
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Override
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateEntity(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @Override
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
