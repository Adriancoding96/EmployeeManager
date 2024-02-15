package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.CertificationDTO;
import com.adrian.employeemanager.mappers.PersistanceMapper;
import com.adrian.employeemanager.model.Certification;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.repository.CertificationRepository;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.service.interfaces.CertificationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CertificationServiceImpl implements CertificationService {

    private final CertificationRepository certificationRepository;
    private final EmployeeRepository employeeRepository;
    private final PersistanceMapper persistanceMapper;

    @Autowired
    public CertificationServiceImpl(CertificationRepository certificationRepository, EmployeeRepository employeeRepository, PersistanceMapper persistanceMapper) {
        this.certificationRepository = certificationRepository;
        this.employeeRepository = employeeRepository;
        this.persistanceMapper = persistanceMapper;
    }

    @Override
    public Certification createCertification(CertificationDTO certificationDTO) {
        Certification certification = persistanceMapper.DTOToCertification(certificationDTO);
        certification.setCreated(LocalDateTime.now());
        certification.setModified(LocalDateTime.now());
        return certificationRepository.save(certification);
    }

    @Override
    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }
}
