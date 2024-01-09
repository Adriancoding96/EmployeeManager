package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository  extends JpaRepository<Education, Long> {
}
