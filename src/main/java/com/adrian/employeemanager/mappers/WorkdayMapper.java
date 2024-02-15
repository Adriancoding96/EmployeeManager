package com.adrian.employeemanager.mappers;

import com.adrian.employeemanager.dto.WorkDTO;
import com.adrian.employeemanager.dto.WorkDayDTO;
import com.adrian.employeemanager.model.Timesheet;
import com.adrian.employeemanager.model.Work;
import com.adrian.employeemanager.model.WorkDay;
import com.adrian.employeemanager.repository.TimesheetRepository;
import com.adrian.employeemanager.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkdayMapper {

    private final TimesheetRepository timesheetRepository;
    private final WorkRepository workRepository;

    @Autowired
    public WorkdayMapper(TimesheetRepository timesheetRepository, WorkRepository workRepository) {
        this.timesheetRepository = timesheetRepository;
        this.workRepository = workRepository;
    }

    public WorkDayDTO toDTO(WorkDay workDay) {
        WorkDayDTO dto = new WorkDayDTO();
        dto.setWorkDayId(workDay.getWorkDayId());
        dto.setTimesheetId(workDay.getTimesheet() != null ? workDay.getTimesheet().getTimeSheetId() : null);
        System.out.println("Workday: " + dto.getTimesheetId());
        dto.setDate(workDay.getDate());
        dto.setCreated(workDay.getCreated());
        dto.setModified(workDay.getModified());

        int totalHours = workDay.getWorkList().stream().mapToInt(Work::getHours).sum();
        dto.setTotalHours(totalHours);

        System.out.println(workDay.getWorkList());
        List<WorkDTO> workDTOS = workDay.getWorkList().stream()
                .map(this::toWorkDTO)
                .collect(Collectors.toList());
        dto.setWorkDTOS(workDTOS);

        return dto;
    }

    public WorkDTO toWorkDTO(Work work) {
        if (work == null) {
            return null;
        }

        WorkDTO workDTO = new WorkDTO();
        workDTO.setWorkId(work.getWorkId());
        workDTO.setWorkDayId(work.getWorkDay() != null ? work.getWorkDay().getWorkDayId() : null);
        workDTO.setHours(work.getHours());
        workDTO.setWorkEnum(work.getWorkType());
        workDTO.setWorkStatusEnum(work.getWorkStatusEnum());
        workDTO.setDescription(work.getDescription());
        workDTO.setCreated(work.getCreated());
        workDTO.setModified(work.getModified());
        return workDTO;
    }



    public WorkDay toEntity(WorkDayDTO workDayDTO) {
        WorkDay workDay = new WorkDay();
        workDay.setWorkDayId(workDayDTO.getWorkDayId());

        Timesheet timesheet = timesheetRepository.findById(workDayDTO.getTimesheetId())
                .orElse(null);
        workDay.setTimesheet(timesheet);
        workDay.setDate(workDayDTO.getDate());
        workDay.setCreated(workDayDTO.getCreated());
        workDay.setModified(workDayDTO.getModified());

        if (workDayDTO.getWorkDTOS() != null) {
            List<Work> works = workDayDTO.getWorkDTOS().stream()
                    .map(this::toWorkEntity)
                    .collect(Collectors.toList());

            for (Work work : works) {
                work.setWorkDay(workDay);
            }

            workDay.setWorkList(works);
        }
        return workDay;
    }

    public Work toWorkEntity(WorkDTO workDTO) {
        Work work;
        if (workDTO.getWorkId() != null) {
            work = workRepository.findById(workDTO.getWorkId()).orElse(new Work());
        } else {
            work = new Work();
        }

        work.setHours(workDTO.getHours());
        work.setWorkType(workDTO.getWorkEnum());
        work.setWorkStatusEnum(workDTO.getWorkStatusEnum());
        work.setDescription(workDTO.getDescription());
        work.setCreated(workDTO.getCreated());
        work.setModified(workDTO.getModified());

        return work;
    }


}
