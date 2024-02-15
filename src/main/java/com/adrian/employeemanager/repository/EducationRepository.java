package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository  extends JpaRepository<Education, Long> {

    List<Education> findByEmployeeEmployeeId(Long employeeId);

}
