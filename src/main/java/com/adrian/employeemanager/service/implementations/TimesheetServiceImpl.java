package com.adrian.employeemanager.service.implementations;

import com.adrian.employeemanager.dto.TimesheetDTO;
import com.adrian.employeemanager.enums.MonthEnum;
import com.adrian.employeemanager.mappers.TimesheetMapper;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.Timesheet;
import com.adrian.employeemanager.model.WorkDay;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.TimesheetRepository;
import com.adrian.employeemanager.service.interfaces.EmployeeService;
import com.adrian.employeemanager.service.interfaces.TimesheetService;
import com.adrian.employeemanager.service.interfaces.WorkdayService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.Month;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    private final TimesheetRepository timesheetRepository;

    private final EmployeeRepository employeeRepository;

    private final TimesheetMapper timesheetMapper;

    private final WorkdayService workdayService;
    private final EmployeeService employeeService;

    @Autowired
    public TimesheetServiceImpl(TimesheetRepository timesheetRepository, EmployeeRepository employeeRepository, TimesheetMapper timesheetMapper, WorkdayService workdayService, EmployeeService employeeService) {
        this.timesheetRepository = timesheetRepository;
        this.employeeRepository = employeeRepository;
        this.timesheetMapper = timesheetMapper;
        this.workdayService = workdayService;
        this.employeeService = employeeService;
    }

    @Override
    public Timesheet createTimesheet(TimesheetDTO timesheetDTO) {
        Timesheet timesheet = timesheetMapper.toEntity(timesheetDTO);
        timesheet.setCreated(LocalDateTime.now());
        timesheet.setModified(LocalDateTime.now());
        return timesheet;
    }

    @Override
    public TimesheetDTO getTimesheetById(Long id) {
        Timesheet timesheet = timesheetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Timesheet with id: " + id + "not found"));
        return timesheetMapper.toDTO(timesheet);
    }

    @Override
    public List<TimesheetDTO> getAllTimesheets() {
        List<Timesheet> timesheets = timesheetRepository.findAll();
        System.out.println(timesheets);
        return timesheets.stream().map(timesheetMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<TimesheetDTO> getAllTimesheetsByEmployeeId(Long id) {
        List<Timesheet> timesheets = timesheetRepository.findByEmployeeEmployeeId(id);
        return timesheets.stream().map(timesheetMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public TimesheetDTO updateTimesheet(Long id, TimesheetDTO dto) {
        Timesheet existingTimesheet = timesheetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Timesheet with id: " + id + " not found"));
        Timesheet updatedTimesheet = timesheetMapper.updateEntityWithDTO(existingTimesheet ,dto);
        Timesheet savedTimesheet = timesheetRepository.save(updatedTimesheet);
        return timesheetMapper.toDTO(savedTimesheet);
    }

    @Override
    public void deleteTimesheet(Long id) {
        if(!timesheetRepository.existsById(id)){
            throw new EntityNotFoundException("Timesheet with id: " + id + " not found");
        }
        timesheetRepository.deleteById(id);
    }

    @Override
    public void createMonthlyTimesheetForAllEmployees(boolean isRestart) {
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        MonthEnum monthEnum = MonthEnum.of(month);
        int currentYear = currentDate.getYear();
        List<Employee> employees = new ArrayList<>();

        if(isRestart){
            employees = employeeService.findEmployeesWithoutTimesheetForMonthAndYear(monthEnum, currentYear);
        } else {
            employees = employeeRepository.findAll();
        }

        for(Employee employee : employees){
            Timesheet newTimesheet = new Timesheet();
            newTimesheet.setEmployee(employee);
            newTimesheet.setMonthEnum(MonthEnum.of(month));
            newTimesheet.setTimesheetYear(currentYear);
            newTimesheet.setApproved(false);
            newTimesheet.setCreated(LocalDateTime.now());
            newTimesheet.setModified(LocalDateTime.now());
            newTimesheet = timesheetRepository.save(newTimesheet);
            List<WorkDay> workDays = workdayService.generateWorkDaysForMonth(month, currentYear);
            for(WorkDay workDay : workDays){
                workDay.setTimesheet(newTimesheet);
                workdayService.createWorkFromEntity(workDay);
            }

            newTimesheet.setWorkDays(workDays);
            timesheetRepository.save(newTimesheet);
        }

    }
    @Override
    public void approveTimesheet(Long timesheetId, Boolean approved) {
        Timesheet timesheet = timesheetRepository.findById(timesheetId)
                .orElseThrow(() -> new EntityNotFoundException("Timesheet with id: " + timesheetId + " not found"));
        timesheet.setApproved(approved);
        System.out.println("Changing status of timesheet");
        Timesheet savedTimesheet = timesheetRepository.save(timesheet);
        System.out.println("Persisted timesheet: " + savedTimesheet.toString());
    }

}
