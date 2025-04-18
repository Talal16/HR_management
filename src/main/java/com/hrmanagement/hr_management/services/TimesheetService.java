package com.hrmanagement.hr_management.services;


import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.mappers.ProjectMapper;
import com.hrmanagement.hr_management.mappers.TimesheetMapper;
import com.hrmanagement.hr_management.mappers.UserMapper;
import com.hrmanagement.hr_management.models.Timesheet;
import com.hrmanagement.hr_management.repositories.ProjectRepository;
import com.hrmanagement.hr_management.repositories.TimesheetRepository;
import com.hrmanagement.hr_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public TimesheetDto createTimesheet(TimesheetDto timesheetDto) {
        Timesheet timesheet = timesheetMapper.toEntity(timesheetDto);
        timesheet.setCreatedAt(LocalDateTime.now());
        timesheet.setUpdatedAt(LocalDateTime.now());

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
        timesheet.setUpdatedAt(LocalDateTime.now());
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

    //get all timesheets by user id
    public List<TimesheetDto> getAllTimesheetsByUserId(long userId) {
        List <Timesheet> timesheets = timesheetRepository.findByUserId(userId);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));

        });
        return timesheetDtos;
    }

    // get all timesheets by project id
    public List<TimesheetDto> getAllTimesheetsByProjectId(long projectId) {
        List <Timesheet> timesheets = timesheetRepository.findByProjectId(projectId);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }

    //get timesheets by user id and project id
    public List<TimesheetDto> getAllTimesheetsByUserIdAndProjectId(long userId, long projectId) {
        List <Timesheet> timesheets = timesheetRepository.findByUserIdAndProjectId(userId, projectId);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));

        });
        return timesheetDtos;
    }

    // get timesheets by start time
    public List<TimesheetDto> getAllTimesheetsByStartTime(LocalDateTime startTime) {
        List <Timesheet> timesheets = timesheetRepository.findByStartTime(startTime);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));

        });
        return timesheetDtos;
    }

    // get timesheets of user where working now
    public List<TimesheetDto> getAllTimesheetsByUserWorkingNow(long userId) {
        List <Timesheet> timesheets = timesheetRepository.findByUserIdAndEndTime(userId, null);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }

    // get timesheets by end time
    public List<TimesheetDto> getAllTimesheetsByEndTime(LocalDateTime endTime) {
        List <Timesheet> timesheets = timesheetRepository.findByEndTime(endTime);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }

    // get timesheets by user by spacific date and time
    public List<TimesheetDto> getAllTimesheetsByUserIdAndStartTime(long userId, LocalDateTime startTime) {
        List <Timesheet> timesheets = timesheetRepository.findByUserIdAndStartTime(userId, startTime);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }

    // get timesheet by userId and start time Range
    public List<TimesheetDto> getAllTimesheetsByUserIdAndStartTimeRange(long userId, LocalDateTime startTimeBegin, LocalDateTime startTimeEnd) {
        List <Timesheet> timesheets = timesheetRepository.findTimesheetByuserIdAndstartTimeBetween(userId, startTimeBegin, startTimeEnd);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }

    // get timesheet by project id
    public List<TimesheetDto> getAllTimesheetsByProjectIdAndStartTime(long projectId, LocalDateTime startTime) {
        List <Timesheet> timesheets = timesheetRepository.findByProjectIdAndStartTime(projectId, startTime);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }

    //  get timesheet By UserId and ProjectId and   StartTime
    public List<TimesheetDto> getAllTimesheetsByUserIdAndProjectIdAndStartTime(long userId, long projectId, LocalDateTime startTime) {
        List <Timesheet> timesheets = timesheetRepository.findByUserIdAndProjectIdAndStartTime(userId, projectId, startTime);
        List <TimesheetDto> timesheetDtos = new ArrayList<>();
        timesheets.forEach(timesheet -> {
            timesheetDtos.add(timesheetMapper.toDto(timesheet));
        });
        return timesheetDtos;
    }


    // start working on project means that no end date
    public void startWorkingOnProject(long userId, long projectId) {
        // check if the user is already working on the project
        List<Timesheet> timesheets = timesheetRepository.findByUserIdAndProjectIdAndEndTime(userId, projectId, null);
        if (!timesheets.isEmpty()) {
            throw new RuntimeException("User is already working on this project");
        }
        // check if the user is already working on another project
        List<Timesheet> timesheets1 = timesheetRepository.findByUserIdAndEndTime(userId, null);
        if (!timesheets1.isEmpty()) {
            throw new RuntimeException("User is already working on another project");
        }

        // create a new timesheet
        Timesheet timesheet = new Timesheet();
        timesheet.setUser(userRepository.getUserById(userId));
        timesheet.setProject(projectRepository.getById(projectId));
        timesheet.setStartTime(LocalDateTime.now());
        timesheet.setEndTime(null);
        timesheet.setCreatedAt(LocalDateTime.now());
        timesheet.setUpdatedAt(LocalDateTime.now());
        timesheetRepository.save(timesheet);
    }
    // start break means update the end time to the current time
    public void endWorkingOnProject(long userId, long projectId) {
        // check if the user is working on the project
        List<Timesheet> timesheets = timesheetRepository.findByUserIdAndProjectIdAndEndTime(userId, projectId, null);
        if (timesheets.isEmpty()) {
            throw new RuntimeException("User is not working on this project");
        }
        // update the end time to the current time
        Timesheet timesheet = timesheets.getFirst();
        timesheet.setEndTime(LocalDateTime.now());
        timesheet.setUpdatedAt(LocalDateTime.now());
        timesheetRepository.save(timesheet);
    }
    // start work create new timesheet


}
