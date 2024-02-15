package com.adrian.employeemanager.listeners;

import com.adrian.employeemanager.service.util.interfaces.TimesheetCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    private final TimesheetCheckService timesheetCheckService;

    @Autowired
    public StartupApplicationListener(TimesheetCheckService timesheetCheckService) {
        this.timesheetCheckService = timesheetCheckService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        timesheetCheckService.checkAndHandleTimesheetsForCurrentMonth();
    }
}
