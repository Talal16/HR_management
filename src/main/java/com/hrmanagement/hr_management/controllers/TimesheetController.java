package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.services.TimesheetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/timesheet")
@Tag(name = "Timesheet Management", description = "APIs for managing timesheets")
public class TimesheetController {

    private final TimesheetService timesheetService;

    @Autowired
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @Operation(summary = "Create a new timesheet")
    @PostMapping
    public ResponseEntity<TimesheetDto> createTimesheet(@Valid @RequestBody TimesheetDto timesheetDto) {
        return ResponseEntity.status(201).body(timesheetService.createTimesheet(timesheetDto));
    }

    @Operation(summary = "Get timesheet by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TimesheetDto> getTimesheetById(@PathVariable Long id) {
        return ResponseEntity.ok(timesheetService.getTimesheet(id));
    }

    @Operation(summary = "Update timesheet")
    @PutMapping("/{id}")
    public ResponseEntity<TimesheetDto> updateTimesheet(@Valid @RequestBody TimesheetDto timesheetDto, @PathVariable Long id) {
        return ResponseEntity.ok(timesheetService.updateTimesheet(id, timesheetDto));
    }

    @Operation(summary = "Delete timesheet")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimesheet(@PathVariable Long id) {
        timesheetService.deleteTimesheet(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all timesheets")
    @GetMapping
    public ResponseEntity<List<TimesheetDto>> getAllTimesheets() {
        return ResponseEntity.ok(timesheetService.getAllTimesheets());
    }

    //---------------------------------------------  statistics in details--------------------------------------
    @Operation(summary = "Get all timesheets by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByUserId(userId));
    }

    @Operation(summary = "Get all timesheets by project ID")
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByProjectId(projectId));
    }

    @Operation(summary = "Get all timesheets by user ID and project ID")
    @GetMapping("/user/{userId}/project/{projectId}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByUserIdAndProjectId(@PathVariable Long userId, @PathVariable Long projectId) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByUserIdAndProjectId(userId, projectId));
    }

    @Operation(summary = "Get all timesheets by start time")
    @GetMapping("/start-time/{startTime}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByStartTime(@PathVariable LocalDateTime startTime) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByStartTime(startTime));
    }

    @Operation(summary = "Get all timesheets by user ID where working now")
    @GetMapping("/user/{userId}/working-now")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByUserWorkingNow(@PathVariable Long userId) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByUserWorkingNow(userId));
    }

    @Operation(summary = "Get all timesheets by end time")
    @GetMapping("/end-time/{endTime}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByEndTime(@PathVariable LocalDateTime endTime) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByEndTime(endTime));
    }

    @Operation(summary = "Get all timesheets by user ID and start time")
    @GetMapping("/user/{userId}/start-time/{startTime}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByUserIdAndStartTime(@PathVariable Long userId, @PathVariable LocalDateTime startTime) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByUserIdAndStartTime(userId, startTime));
    }

    @Operation(summary = "Get all timesheets by user ID and start time range")
    @GetMapping("/user/{userId}/start-time-range")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByUserIdAndStartTimeRange(@PathVariable Long userId, @RequestParam LocalDateTime startTimeBegin, @RequestParam LocalDateTime startTimeEnd) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByUserIdAndStartTimeRange(userId, startTimeBegin, startTimeEnd));
    }

    @Operation(summary = "Get all timesheets by project ID and start time")
    @GetMapping("/project/{projectId}/start-time/{startTime}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByProjectIdAndStartTime(@PathVariable Long projectId, @PathVariable LocalDateTime startTime) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByProjectIdAndStartTime(projectId, startTime));
    }

    @Operation(summary = "Get all timesheets by user ID, project ID, and start time")
    @GetMapping("/user/{userId}/project/{projectId}/start-time/{startTime}")
    public ResponseEntity<List<TimesheetDto>> getAllTimesheetsByUserIdAndProjectIdAndStartTime(@PathVariable Long userId, @PathVariable Long projectId, @PathVariable LocalDateTime startTime) {
        return ResponseEntity.ok(timesheetService.getAllTimesheetsByUserIdAndProjectIdAndStartTime(userId, projectId, startTime));
    }
}