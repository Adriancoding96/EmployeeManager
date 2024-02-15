package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long> {
}
