package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.EducationDTO;
import com.adrian.employeemanager.mappers.EducationMapper;
import com.adrian.employeemanager.model.Education;
import com.adrian.employeemanager.repository.EducationRepository;
import com.adrian.employeemanager.service.interfaces.EducationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationServieImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    @Autowired
    public EducationServieImpl(EducationRepository educationRepository, EducationMapper educationMapper) {
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
    }

    @Override
    public EducationDTO createEducation(EducationDTO educationDTO) {
        Education education = educationMapper.toEducation(educationDTO);
        education.setCreated(LocalDateTime.now());
        education.setModified(LocalDateTime.now());
        Education savedEducation = educationRepository.save(education);
        return educationMapper.toDTO(savedEducation);
    }

    @Override
    public EducationDTO getEducationById(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education with id: " + id + " not found"));
        return educationMapper.toDTO(education);
    }

    @Override
    public List<EducationDTO> getAllEducations() {
        List<Education> educations = educationRepository.findAll();
        return educations.stream().map(educationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<EducationDTO> getAllEducationsByEmployeeId(Long employeeId) {
        List<Education> educations = educationRepository.findByEmployeeEmployeeId(employeeId);
        return educations.stream().map(educationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EducationDTO updateEducation(Long id, EducationDTO educationDTO) {
        Education existingEducation = educationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Education with id: " + id + " not found"));

        Education updatedEducation = educationMapper.updateEntityWithDTO(existingEducation, educationDTO);

        Education savedEducation = educationRepository.save(updatedEducation);
        return educationMapper.toDTO(savedEducation);
    }

    @Override
    public void deleteEducation(Long id) {
        if(!educationRepository.existsById(id)) {
            throw new EntityNotFoundException("Education with id: " + id + " not found");
        }
        educationRepository.deleteById(id);
    }
}

