package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.TimesheetDTO;
import com.adrian.employeemanager.model.Timesheet;

import java.util.List;


public interface TimesheetService {
    Timesheet createTimesheet(TimesheetDTO timesheetDTO);
    TimesheetDTO getTimesheetById(Long id);
    List<TimesheetDTO> getAllTimesheets();
    List<TimesheetDTO> getAllTimesheetsByEmployeeId(Long id);
    TimesheetDTO updateTimesheet(Long id, TimesheetDTO dto);
    void deleteTimesheet(Long id);
    void createMonthlyTimesheetForAllEmployees(boolean isRestart);
    void approveTimesheet(Long timesheetId, Boolean approved);



}
