package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    List<Timesheet> findByUserId(Long userId);
    List<Timesheet> findByProjectId(Long projectId);
    List<Timesheet> findByStartTime(LocalDateTime startTime);
    List<Timesheet> findByEndTime(LocalDateTime endTime);

    List<Timesheet> findByUserIdAndProjectId(Long userId, Long projectId);
    List<Timesheet> findByUserIdAndStartTime(Long userId, LocalDateTime startTime);
    List<Timesheet> findByUserIdAndEndTime(Long userId, LocalDateTime endTime);
    List<Timesheet> findTimesheetByuserIdAndstartTimeBetween(long userId, LocalDateTime startTimeBegin, LocalDateTime startTimeEnd);

//findByProjectIdAndStartTime
    List<Timesheet> findByProjectIdAndStartTime(Long projectId, LocalDateTime startTime);
    List<Timesheet> findByProjectIdAndEndTime(Long projectId, LocalDateTime endTime);
    List<Timesheet> findByUserIdAndProjectIdAndStartTime(Long userId, Long projectId, LocalDateTime startTime);
    List<Timesheet> findByUserIdAndProjectIdAndEndTime(Long userId, Long projectId, LocalDateTime endTime);






}
