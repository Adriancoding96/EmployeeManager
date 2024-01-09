package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.PastEmployment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastEmploymentRepository  extends JpaRepository<PastEmployment, Long> {
}
