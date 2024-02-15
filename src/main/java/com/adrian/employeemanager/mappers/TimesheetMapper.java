package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.TimesheetDTO;
import com.adrian.employeemanager.dto.WorkDTO;
import com.adrian.employeemanager.dto.WorkDayDTO;
import com.adrian.employeemanager.model.Employee;
import com.adrian.employeemanager.model.Timesheet;
import com.adrian.employeemanager.model.Work;
import com.adrian.employeemanager.model.WorkDay;
import com.adrian.employeemanager.repository.EmployeeRepository;
import com.adrian.employeemanager.repository.WorkdayRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimesheetMapper {

    private final EmployeeRepository employeeRepository;
    private final WorkdayRepository workdayRepository;

    @Autowired
    public TimesheetMapper(EmployeeRepository employeeRepository, WorkdayRepository workdayRepository) {
        this.employeeRepository = employeeRepository;
        this.workdayRepository = workdayRepository;
    }

    public Timesheet toEntity(TimesheetDTO timesheetDTO) {
        Timesheet timesheet = new Timesheet();
        if(timesheetDTO.getTimeSheetId() != null) {
            timesheet.setTimeSheetId(timesheetDTO.getTimeSheetId());
        }

        timesheet.setTimesheetYear(timesheetDTO.getYear());
        timesheet.setMonthEnum(timesheetDTO.getMonthEnum());
        timesheet.setApproved(timesheetDTO.isApproved());
        timesheet.setCreated(timesheetDTO.getCreated());
        timesheet.setModified(timesheetDTO.getModified());

        if(timesheetDTO.getEmployeeId() != null){
            Employee employee = employeeRepository.findById(timesheetDTO.getEmployeeId())
                    .orElseThrow(() -> new EntityNotFoundException("Employee with id: " + timesheetDTO.getEmployeeId() + " not found"));
            timesheet.setEmployee(employee);
            timesheet.setWorkDays(workdayRepository.findAllByTimesheetTimeSheetId(timesheetDTO.getTimeSheetId()));
        }
        return timesheet;
    }

    public TimesheetDTO toDTO(Timesheet timesheet) {
        if(timesheet == null) {
            return null;
        }
        TimesheetDTO dto = new TimesheetDTO();
        dto.setTimeSheetId(timesheet.getTimeSheetId());
        dto.setEmployeeId(timesheet.getEmployee().getEmployeeId());
        dto.setMonthEnum(timesheet.getMonthEnum());
        dto.setYear(timesheet.getTimesheetYear());
        dto.setApproved(timesheet.isApproved());
        dto.setCreated(timesheet.getCreated());
        dto.setModified(timesheet.getModified());

        List<WorkDayDTO> workDayDTOs = timesheet.getWorkDays().stream()
                .map(this::convertToWorkDayDTO)
                .collect(Collectors.toList());
        dto.setWorkDays(workDayDTOs);

        return dto;
    }

    private WorkDayDTO convertToWorkDayDTO(WorkDay workDay) {
        WorkDayDTO dto = new WorkDayDTO();
        dto.setWorkDayId(workDay.getWorkDayId());
        dto.setTimesheetId(workDay.getTimesheet().getTimeSheetId());
        dto.setDate(workDay.getDate());
        dto.setTotalHours(workDay.getTotalHours());
        dto.setCreated(workDay.getCreated());
        dto.setModified(workDay.getModified());

        List<WorkDTO> workDTOS = workDay.getWorkList().stream()
                .map(this::convertToWorkDTO)
                .collect(Collectors.toList());
        dto.setWorkDTOS(workDTOS);
        return dto;
    }

    private WorkDTO convertToWorkDTO(Work work) {
        WorkDTO dto = new WorkDTO();
        dto.setWorkDayId(work.getWorkDay().getWorkDayId());
        dto.setWorkId(work.getWorkId());
        dto.setHours(work.getHours());
        dto.setWorkEnum(work.getWorkType());
        dto.setDescription(work.getDescription());
        dto.setCreated(work.getCreated());
        dto.setModified(work.getModified());

        return dto;
    }


    public Timesheet updateEntityWithDTO(Timesheet existingTimesheet, TimesheetDTO dto) {
        return null;
    }
}
