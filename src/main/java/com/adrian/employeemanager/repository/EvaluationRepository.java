package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository  extends JpaRepository<Evaluation, Long> {
}
