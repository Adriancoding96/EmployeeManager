package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.WorkDTO;
import com.adrian.employeemanager.dto.WorkDayDTO;
import com.adrian.employeemanager.model.Timesheet;
import com.adrian.employeemanager.model.Work;
import com.adrian.employeemanager.model.WorkDay;
import com.adrian.employeemanager.repository.WorkdayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface WorkdayService {

    WorkDay createWorkDayFromDTO(WorkDayDTO workDayDTO);
    WorkDay createWorkFromEntity(WorkDay workDay);
    List<WorkDayDTO> getAllWorDaysAsDTO();
    List<WorkDay> getAllWorkDaysAsEntity();
    List<WorkDayDTO> getAllWorkDaysAsDTOByTimesheetId(Long timesheetId);
    List<WorkDay> getAllWorkDatsAsEntityByTimesheetId(Long timesheetId);
    List<WorkDay> generateWorkDaysForMonth(int month, int year);
    WorkDayDTO findByDate(LocalDate date, Long timesheetId);
    Void tmpCreateWork(Long workDayId);

}
