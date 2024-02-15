package com.adrian.employeemanager.controller;

import com.adrian.employeemanager.controller.interfaces.EntityController;
import com.adrian.employeemanager.dto.EmergencyContactDTO;
import com.adrian.employeemanager.model.EmergencyContact;
import com.adrian.employeemanager.service.interfaces.EmergencyContactService;
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
@RequestMapping("/api/v1/ice")
public class EmergencyContactController{

    private final EmergencyContactService emergencyContactService;

    @Autowired
    public EmergencyContactController(EmergencyContactService emergencyContactService) {
        this.emergencyContactService = emergencyContactService;
    }


    @PostMapping
    public ResponseEntity<EmergencyContact> createEntity(@RequestBody EmergencyContactDTO emergencyContactDTO) {
        EmergencyContact createdEmergencyContact = emergencyContactService.createEmergencyContact(emergencyContactDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmergencyContact);
    }


    public ResponseEntity<EmergencyContact> findById(Long aLong) {
        return null;
    }


    public ResponseEntity<EmergencyContact> findByEmployeeId(Long entityId, Long employeeId) {
        return null;
    }


    @GetMapping
    public ResponseEntity<List<EmergencyContact>> findAll() {
        List<EmergencyContact> emergencyContacts = emergencyContactService.getAllEmergencyContacts();
        return ResponseEntity.ok(emergencyContacts);
    }


    public ResponseEntity<List<EmergencyContact>> findAllByEmployeeId(Long aLong) {
        return null;
    }


    public ResponseEntity<EmergencyContact> updateEntity(Long aLong, EmergencyContact entity) {
        return null;
    }

    public ResponseEntity<Void> deleteEntity(Long aLong) {
        return null;
    }
}
