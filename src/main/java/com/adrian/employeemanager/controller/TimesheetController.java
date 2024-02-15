package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.dto.TimesheetApprovalDTO;
import com.adrian.employeemanager.dto.TimesheetDTO;
import com.adrian.employeemanager.model.Timesheet;
import com.adrian.employeemanager.service.interfaces.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/v1/timesheet")
public class TimesheetController {

    private final TimesheetService timesheetService;

    @Autowired
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @PostMapping
    public ResponseEntity<Timesheet> createEntity(@RequestBody TimesheetDTO timesheetDTO){
        Timesheet newTimesheet = timesheetService.createTimesheet(timesheetDTO);
        return ResponseEntity.ok(newTimesheet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimesheetDTO> findById(@PathVariable Long id){
        TimesheetDTO timesheetDTO = timesheetService.getTimesheetById(id);
        return ResponseEntity.ok(timesheetDTO);
    }

    @GetMapping("/timesheet/{timesheetId}")
    public ResponseEntity<List<TimesheetDTO>> findAllByEmployeeId(@PathVariable Long employeeId){
        List<TimesheetDTO> timesheetDTOS = timesheetService.getAllTimesheetsByEmployeeId(employeeId);
        return ResponseEntity.ok(timesheetDTOS);
    }

    @GetMapping
    public ResponseEntity<List<TimesheetDTO>> findAll(){
        List<TimesheetDTO> timesheetDTOS = timesheetService.getAllTimesheets();
        return ResponseEntity.ok(timesheetDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id){
        timesheetService.deleteTimesheet(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/approve")
    public ResponseEntity<Void> approveTimesheet(@RequestBody TimesheetApprovalDTO approvalDTO) {
        System.out.println("New request to change timesheet status");
        timesheetService.approveTimesheet(approvalDTO.getTimesheetId(), approvalDTO.getApproved());
        return ResponseEntity.ok().build();
    }


}
