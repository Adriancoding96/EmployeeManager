package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.WorkDTO;
import com.adrian.employeemanager.dto.WorkDayDTO;
import com.adrian.employeemanager.enums.WorkEnum;
import com.adrian.employeemanager.enums.WorkStatusEnum;
import com.adrian.employeemanager.mappers.WorkdayMapper;
import com.adrian.employeemanager.model.Timesheet;
import com.adrian.employeemanager.model.Work;
import com.adrian.employeemanager.model.WorkDay;
import com.adrian.employeemanager.repository.WorkRepository;
import com.adrian.employeemanager.repository.WorkdayRepository;
import com.adrian.employeemanager.service.interfaces.WorkdayService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkdayServiceImpl implements WorkdayService {

    private final WorkdayRepository workdayRepository;
    private final WorkRepository workRepository;
    private final WorkdayMapper workdayMapper;

    @Autowired
    public WorkdayServiceImpl(WorkdayRepository workdayRepository, WorkRepository workRepository, WorkdayMapper workdayMapper) {
        this.workdayRepository = workdayRepository;
        this.workRepository = workRepository;
        this.workdayMapper = workdayMapper;
    }

    @Override
    public WorkDay createWorkDayFromDTO(WorkDayDTO workDayDTO) {
        WorkDay workDay = workdayMapper.toEntity(workDayDTO);
        return workdayRepository.save(workDay);
    }

    @Override
    public WorkDay createWorkFromEntity(WorkDay workDay) {
        return workdayRepository.save(workDay);
    }

    @Override
    public List<WorkDayDTO> getAllWorDaysAsDTO() {
        List<WorkDay> workDays = workdayRepository.findAll();
        for(WorkDay workDay: workDays) {
            System.out.println(workDay.toString());
        }
        return workDays.stream().map(workdayMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<WorkDay> getAllWorkDaysAsEntity() {
        return workdayRepository.findAll();
    }

    @Override
    public List<WorkDayDTO> getAllWorkDaysAsDTOByTimesheetId(Long timesheetId) {
        List<WorkDay> workDays = workdayRepository.findAllByTimesheetTimeSheetId(timesheetId);
        return workDays.stream().map(workdayMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<WorkDay> getAllWorkDatsAsEntityByTimesheetId(Long timesheetId) {
        return workdayRepository.findAllByTimesheetTimeSheetId(timesheetId);
    }

    @Override
    public List<WorkDay> generateWorkDaysForMonth(int month, int year){
        List<WorkDay> workDays = new ArrayList<>();
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        for(int i = 1; i <= daysInMonth ; i++){
            LocalDate date = LocalDate.of(year, month, i);

            WorkDay workDay = new WorkDay();
            workDay.setDate(date);
            workDay.setTotalHours(0);
            workDay.setCreated(LocalDateTime.now());
            workDay.setModified(LocalDateTime.now());
            workDay = workdayRepository.save(workDay);

            if(workDay.getWorkDayId() == 1L){
                tmpCreateWork(workDay.getWorkDayId());
            }

            workDays.add(workDay);
        }
        return workDays;
    }

    @Override
    public WorkDayDTO findByDate(LocalDate date, Long timesheetId) {
        WorkDay workDay = workdayRepository.findByDateAndTimesheetTimeSheetId(date, timesheetId)
                .orElseThrow(() -> new EntityNotFoundException("Workday with date: " + date));
        WorkDayDTO workDayDTO = workdayMapper.toDTO(workDay);
        return workDayDTO;
    }

    @Override
    public Void tmpCreateWork(Long workDayId) {
        WorkDay workDay = workdayRepository.findById(workDayId)
                .orElseThrow(() -> new EntityNotFoundException("Workday with id: " + workDayId + "not found"));

        Work work1 = new Work();
        work1.setWorkDay(workDay);
        work1.setWorkType(WorkEnum.BACKEND);
        work1.setWorkStatusEnum(WorkStatusEnum.INOFFICE);
        work1.setHours(4);
        work1.setDescription("Implemented Data Transfer Objects for entities that have a direct relationship to the timesheet entity.");
        work1.setCreated(LocalDateTime.now());
        work1.setModified(LocalDateTime.now());

        Work work2 = new Work();
        work2.setWorkDay(workDay);
        work2.setWorkType(WorkEnum.FRONTEND);
        work2.setWorkStatusEnum(WorkStatusEnum.INOFFICE);
        work2.setHours(1);
        work2.setDescription("Built a datagrid that has expandable rows to show additional information about the entries.");
        work2.setCreated(LocalDateTime.now());
        work2.setModified(LocalDateTime.now());

        Work work3 = new Work();
        work3.setWorkDay(workDay);
        work3.setWorkType(WorkEnum.DOCUMENTATION);
        work3.setWorkStatusEnum(WorkStatusEnum.INOFFICE);
        work3.setHours(1);
        work3.setDescription("Wrote documentation about complicated mapping functions that is using generics in the backend.");
        work3.setCreated(LocalDateTime.now());
        work3.setModified(LocalDateTime.now());

        Work work4 = new Work();
        work4.setWorkDay(workDay);
        work4.setWorkType(WorkEnum.ABSENT);
        work4.setWorkStatusEnum(WorkStatusEnum.TIMEOFF);
        work4.setHours(0);
        work4.setDescription("Booked time off for doctors appointment.");
        work4.setCreated(LocalDateTime.now());
        work4.setModified(LocalDateTime.now());

        workRepository.save(work1);
        workRepository.save(work2);
        workRepository.save(work3);
        workRepository.save(work4);

        workDay.getWorkList().add(work1);
        workDay.getWorkList().add(work2);
        workDay.getWorkList().add(work3);
        workDay.getWorkList().add(work4);
        workdayRepository.save(workDay);
        return null;
    }
}
