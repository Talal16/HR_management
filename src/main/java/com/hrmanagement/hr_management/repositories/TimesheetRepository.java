package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId")
    List<Timesheet> findByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Timesheet t WHERE t.project.id = :projectId")
    List<Timesheet> findByProjectId(@Param("projectId") Long projectId);

    @Query("SELECT t FROM Timesheet t WHERE t.startTime = :startTime")
    List<Timesheet> findByStartTime(@Param("startTime") LocalDateTime startTime);

    @Query("SELECT t FROM Timesheet t WHERE t.endTime = :endTime")
    List<Timesheet> findByEndTime(@Param("endTime") LocalDateTime endTime);

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId AND t.project.id = :projectId")
    List<Timesheet> findByUserIdAndProjectId(@Param("userId") Long userId, @Param("projectId") Long projectId);

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId AND t.startTime = :startTime")
    List<Timesheet> findByUserIdAndStartTime(@Param("userId") Long userId, @Param("startTime") LocalDateTime startTime);

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId AND t.endTime = :endTime")
    List<Timesheet> findByUserIdAndEndTime(@Param("userId") Long userId, @Param("endTime") LocalDateTime endTime);

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId AND t.startTime BETWEEN :startTimeBegin AND :startTimeEnd")
    List<Timesheet> findByUserIdAndStartTimeBetween(@Param("userId") Long userId, @Param("startTimeBegin") LocalDateTime startTimeBegin, @Param("startTimeEnd") LocalDateTime startTimeEnd);

    @Query("SELECT t FROM Timesheet t WHERE t.project.id = :projectId AND t.startTime = :startTime")
    List<Timesheet> findByProjectIdAndStartTime(@Param("projectId") Long projectId, @Param("startTime") LocalDateTime startTime);

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId AND t.project.id = :projectId AND t.startTime = :startTime")
    List<Timesheet> findByUserIdAndProjectIdAndStartTime(@Param("userId") Long userId, @Param("projectId") Long projectId, @Param("startTime") LocalDateTime startTime);

    @Query("SELECT t FROM Timesheet t WHERE t.user.id = :userId AND t.project.id = :projectId AND t.endTime = :endTime")
    List<Timesheet> findByUserIdAndProjectIdAndEndTime(@Param("userId") Long userId, @Param("projectId") Long projectId, @Param("endTime") LocalDateTime endTime);
}