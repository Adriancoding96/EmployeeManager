package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.EducationDTO;
import com.adrian.employeemanager.model.Education;

import java.util.List;

public interface EducationService {

    EducationDTO createEducation(EducationDTO educationDTO);

    EducationDTO getEducationById(Long id);

    List<EducationDTO> getAllEducations();

    List<EducationDTO> getAllEducationsByEmployeeId(Long employeeId);

    EducationDTO updateEducation(Long id, EducationDTO educationDTO);

    void deleteEducation(Long id);
}
