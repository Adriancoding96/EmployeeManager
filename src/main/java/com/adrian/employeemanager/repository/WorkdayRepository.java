package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkdayRepository extends JpaRepository<WorkDay, Long> {
    List<WorkDay> findAllByTimesheetTimeSheetId(Long timesheetId);

    Optional<WorkDay> findByDateAndTimesheetTimeSheetId(LocalDate date, Long timesheetId);
}
