package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.dto.WorkDTO;
import com.adrian.employeemanager.service.interfaces.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/v1/work")
public class WorkController {

    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkDTO> GetWorkById(@PathVariable Long id){
        WorkDTO workDTO = workService.getWorkById(id);
        return ResponseEntity.ok(workDTO);
    }
}
