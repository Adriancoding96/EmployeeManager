package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.EducationDTO;
import com.adrian.employeemanager.model.Education;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.repository.EducationRepository;
import com.adrian.employeemanager.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {

    private final EmployeeRepository employeeRepository;
    private final EducationRepository educationRepository;

    @Autowired
    public EducationMapper(EmployeeRepository employeeRepository, EducationRepository educationRepository) {
        this.employeeRepository = employeeRepository;
        this.educationRepository = educationRepository;
    }

    public EducationDTO toDTO(Education education) {
        if (education == null) {
            return null;
        }

        EducationDTO dto = new EducationDTO();
        dto.setEducationId(education.getEducationId());
        if (education.getEmployee() != null) {
            dto.setEmployeeId(education.getEmployee().getEmployeeId());
        }
        dto.setEducationType(education.getEducationType());
        dto.setDegree(education.getDegree());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        dto.setCreated(education.getCreated());
        dto.setModified(education.getModified());
        return dto;
    }

    public Education toEducation(EducationDTO educationDTO) {
        Education education;

        if (educationDTO.getEducationId() != null) {
            education = educationRepository.findById(educationDTO.getEducationId())
                    .orElseThrow(() -> new EntityNotFoundException("Education with ID: " + educationDTO.getEducationId() + " not found!" ));
        } else {
            education = new Education();
        }
        education.setEducationType(educationDTO.getEducationType());
        education.setDegree(educationDTO.getDegree());
        education.setStartDate(educationDTO.getStartDate());
        education.setEndDate(educationDTO.getEndDate());
        education.setCreated(educationDTO.getCreated());
        education.setModified(educationDTO.getModified());

        if(educationDTO.getEmployeeId() != null) {
            Employee employee = employeeRepository.findById(educationDTO.getEmployeeId())
                    .orElseThrow(() -> new EntityNotFoundException("Employee with ID: " + educationDTO.getEmployeeId() + " not found!" ));

            education.setEmployee(employee);
        }

        return education;
    }

    public Education updateEntityWithDTO(Education existingEducation, EducationDTO educationDTO) {
        if (educationDTO == null) {
            return null;
        }

        if (educationDTO.getDegree() != null) {
            existingEducation.setDegree(educationDTO.getDegree());
        }
        if (educationDTO.getStartDate() != null) {
            existingEducation.setStartDate(educationDTO.getStartDate());
        }
        if (educationDTO.getEndDate() != null) {
            existingEducation.setEndDate(educationDTO.getEndDate());
        }
        if (educationDTO.getEducationType() != null) {
            existingEducation.setEducationType(educationDTO.getEducationType());
        }

        if (educationDTO.getEmployeeId() != null) {
            Employee employee = employeeRepository.findById(educationDTO.getEmployeeId())
                    .orElseThrow(() -> new EntityNotFoundException("Employee with ID: " + educationDTO.getEmployeeId() + " not found!"));
            existingEducation.setEmployee(employee);
        }

        return existingEducation;
    }
}
