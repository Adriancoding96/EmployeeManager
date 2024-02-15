package com.adrian.employeemanager.service.util.implementations;

import com.adrian.employeemanager.enums.MonthEnum;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import com.adrian.employeemanager.service.interfaces.TimesheetService;
import com.adrian.employeemanager.service.util.interfaces.TimesheetCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TimesheetCheckServiceImpl implements TimesheetCheckService {

    private final TimesheetService timesheetService;
    private final EmployeeService employeeService;

    @Autowired
    public TimesheetCheckServiceImpl(TimesheetService timesheetService, EmployeeService employeeService) {
        this.timesheetService = timesheetService;
        this.employeeService = employeeService;
    }

    @Override
    public void checkAndHandleTimesheetsForCurrentMonth() {
        timesheetService.createMonthlyTimesheetForAllEmployees(true);
    }
}
