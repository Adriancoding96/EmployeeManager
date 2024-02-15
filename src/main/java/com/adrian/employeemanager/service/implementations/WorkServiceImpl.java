package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.WorkDTO;
import com.adrian.employeemanager.mappers.WorkdayMapper;
import com.adrian.employeemanager.repository.WorkRepository;
import com.adrian.employeemanager.service.interfaces.WorkService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adrian.employeemanager.model.Work;

@Service
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;
    private final WorkdayMapper workdayMapper;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository, WorkdayMapper workdayMapper) {
        this.workRepository = workRepository;
        this.workdayMapper = workdayMapper;
    }

    @Override
    public WorkDTO getWorkById(Long id) {
        Work work = workRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Work with id: " + id + " not found"));

        return workdayMapper.toWorkDTO(work);
    }
}
