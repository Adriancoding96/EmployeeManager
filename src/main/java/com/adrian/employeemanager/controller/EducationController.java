package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.EducationDTO;
import com.adrian.employeemanager.model.Education;
import com.adrian.employeemanager.service.interfaces.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/v1/education")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<EducationDTO> createEntity(@RequestBody EducationDTO educationDTO) {
        EducationDTO createdEducation = educationService.createEducation(educationDTO);
        return ResponseEntity.ok(createdEducation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDTO> findById(@PathVariable Long id) {
        EducationDTO educationDTO = educationService.getEducationById(id);
        return ResponseEntity.ok(educationDTO);
    }


    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EducationDTO>> findByEmployeeId(@PathVariable Long employeeId) {
        List<EducationDTO> educationDTOs = educationService.getAllEducationsByEmployeeId(employeeId);
        return ResponseEntity.ok(educationDTOs);
    }

    @GetMapping
    public ResponseEntity<List<EducationDTO>> findAll() {
        List<EducationDTO> educations = educationService.getAllEducations();
        return ResponseEntity.ok(educations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDTO> updateEntity(@PathVariable Long id, @RequestBody EducationDTO educationDTO) {
        EducationDTO updatedEducation = educationService.updateEducation(id, educationDTO);
        return ResponseEntity.ok(updatedEducation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.ok().build();
    }
}
