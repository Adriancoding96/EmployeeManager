package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.PastEmploymentDTO;
import com.adrian.employeemanager.model.PastEmployment;

import java.util.List;

public interface PastEmploymentService {

    PastEmployment createPastEmployment(PastEmploymentDTO pastEmploymentDTO);
    List<PastEmployment> getAllPastEmployments();
}
