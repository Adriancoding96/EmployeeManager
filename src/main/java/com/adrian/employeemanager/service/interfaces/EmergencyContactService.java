package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.EmergencyContactDTO;
import com.adrian.employeemanager.model.EmergencyContact;

import java.util.List;

public interface EmergencyContactService {
    EmergencyContact createEmergencyContact(EmergencyContactDTO emergencyContactDTO);
    List<EmergencyContact> getAllEmergencyContacts();
}
