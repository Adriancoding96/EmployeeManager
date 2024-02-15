package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.PastEmploymentDTO;
import com.adrian.employeemanager.model.PastEmployment;
import com.adrian.employeemanager.service.interfaces.PastEmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/past-employment")
public class PastEmploymentController{

    private final PastEmploymentService pastEmploymentService;

    @Autowired
    public PastEmploymentController(PastEmploymentService pastEmploymentService) {
        this.pastEmploymentService = pastEmploymentService;
    }


    @PostMapping
    public ResponseEntity<PastEmployment> createEntity(@RequestBody PastEmploymentDTO pastEmploymentDTO) {
       PastEmployment createdPastEmployment = pastEmploymentService.createPastEmployment(pastEmploymentDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdPastEmployment);
    }


    public ResponseEntity<PastEmployment> findById(Long aLong) {
        return null;
    }


    public ResponseEntity<PastEmployment> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<PastEmployment>> findAll() {
        List<PastEmployment> pastEmployments = pastEmploymentService.getAllPastEmployments();
        return ResponseEntity.ok(pastEmployments);
    }


    public ResponseEntity<List<PastEmployment>> findAllByEmployeeId(Long aLong) {
        return null;
    }


    public ResponseEntity<PastEmployment> updateEntity(Long aLong, PastEmployment entity) {
        return null;
    }


    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
