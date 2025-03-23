package com.hrmanagement.hr_management.services;


import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.mappers.ProjectMapper;
import com.hrmanagement.hr_management.mappers.TimesheetMapper;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.Timesheet;
import com.hrmanagement.hr_management.repositories.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimesheetService {

    @Autowired
    private TimesheetRepository  timesheetRepository;
    @Autowired
    private TimesheetMapper timesheetMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProjectMapper projectMapper;

    public TimesheetDto createTimesheet(TimesheetDto timesheetDto) {
        Timesheet timesheet = timesheetMapper.toEntity(timesheetDto);

        return timesheetMapper.toDto( timesheetRepository.save(timesheet));
    }

    //get timesheet by id
    public TimesheetDto getTimesheet(long id) {
        return timesheetMapper.toDto(timesheetRepository.findById(id).get());
    }

    //update timesheet

    public TimesheetDto updateTimesheet(long id, TimesheetDto timesheetDto) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        timesheet.setId(id);
        timesheet.setUser(userMapper.toEntity(timesheetDto.getUser()));
        timesheet.setProject(projectMapper.toEntity(timesheetDto.getProject()));
        timesheet.setStartTime(timesheetDto.getStartTime());
        timesheet.setEndTime(timesheetDto.getEndTime());

        return timesheetMapper.toDto(timesheetRepository.save(timesheet));
    }

    //delete timesheet
    public void deleteTimesheet(long id) {
        timesheetRepository.deleteById(id);
    }

    //get all timesheets

    public List<TimesheetDto> getAllTimesheets() {
        List <Timesheet> timesheets = timesheetRepository.findAll();
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));

        });
        return timesheetDtos;
    }


}
