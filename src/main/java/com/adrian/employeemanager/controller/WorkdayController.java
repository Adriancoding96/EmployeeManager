package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.dto.WorkDayDTO;
import com.adrian.employeemanager.model.WorkDay;
import com.adrian.employeemanager.service.interfaces.WorkdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/v1/workday")
public class WorkdayController {

    private final WorkdayService workdayService;

    @Autowired
    public WorkdayController(WorkdayService workdayService) {
        this.workdayService = workdayService;
    }

    @GetMapping("/byDateAndTimesheet")
    public ResponseEntity<WorkDayDTO> getWorkdayByDateAndTimesheetId(
            @RequestParam("timesheetId") Long timesheetId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

            WorkDayDTO workDayDTO = workdayService.findByDate(date, timesheetId);
        return ResponseEntity.ok(workDayDTO);
    }

    @GetMapping
    public ResponseEntity<List<WorkDayDTO>> getAllWorkdaysAsDTO() {
        List<WorkDayDTO> workDayDTOList = workdayService.getAllWorDaysAsDTO();
        return ResponseEntity.ok(workDayDTOList);
    }
}

