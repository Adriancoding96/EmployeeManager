package com.adrian.employeemanager.service.interfaces;

import com.adrian.employeemanager.dto.CertificationDTO;
import com.adrian.employeemanager.model.Certification;

import java.util.List;

public interface CertificationService {

    Certification createCertification(CertificationDTO certificationDTO);
    List<Certification> getAllCertifications();
}
