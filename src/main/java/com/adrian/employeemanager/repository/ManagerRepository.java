package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository  extends JpaRepository<Manager, Long> {
}
