package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
