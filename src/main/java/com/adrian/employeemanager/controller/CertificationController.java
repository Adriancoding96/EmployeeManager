package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.CertificationDTO;
import com.adrian.employeemanager.model.Certification;
import com.adrian.employeemanager.service.interfaces.CertificationService;
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
@RequestMapping("/api/v1/certification")
public class CertificationController {

    private final CertificationService certificationService;

    @Autowired
    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }


    @PostMapping
    public ResponseEntity<Certification> createEntity(@RequestBody CertificationDTO certificationDTO) {
        Certification createdCertification = certificationService.createCertification(certificationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCertification);
    }


    public ResponseEntity<Certification> findById(Long aLong) {
        return null;
    }


    public ResponseEntity<Certification> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<Certification>> findAll() {
        List<Certification> certifications = certificationService.getAllCertifications();
        return ResponseEntity.ok(certifications);
    }


    public ResponseEntity<List<Certification>> findAllByEmployeeId(Long aLong) {
        return null;
    }


    public ResponseEntity<Certification> updateEntity(Long aLong, Certification entity) {
        return null;
    }


    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
