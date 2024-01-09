package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyContactRepository  extends JpaRepository<EmergencyContact, Long> {
}
