package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository  extends JpaRepository<Certification, Long> {
}
