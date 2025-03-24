package com.hrmanagement.hr_management.controllers;


import com.hrmanagement.hr_management.dto.TimesheetDto;
import com.hrmanagement.hr_management.services.TimesheetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/timesheet")
@Tag(name = "Timesheet Management", description = "APIs for managing timesheets")
public class TimesheetController {
    @Autowired
    private TimesheetService timesheetService;

    //create new timesheet
    @Operation(summary = "create a new timesheet")
    @PostMapping
    public TimesheetDto createTimesheet(@RequestBody TimesheetDto timesheetDto) {
        return timesheetService.createTimesheet(timesheetDto);
    }

    // get timesheet by id
    @Operation(summary = "get timesheet by id")
    @GetMapping("/{id}")
    public TimesheetDto getTimesheetById(@PathVariable Long id) {
        return timesheetService.getTimesheet(id);
    }

    // update timesheet
    @Operation(summary = "update timesheet")
    @PutMapping("/{id}")
    public TimesheetDto updateTimesheet(@RequestBody TimesheetDto timesheetDto, @PathVariable Long id) {
        return timesheetService.updateTimesheet(id, timesheetDto);
    }

    // delete timesheet
    @Operation(summary = "delete timesheet")
    @DeleteMapping("/{id}")
    public void deleteTimesheet(@PathVariable Long id) {
        timesheetService.deleteTimesheet(id);
    }

    // get all timesheets
    @Operation(summary = "get all timesheets")
    @GetMapping
    public List<TimesheetDto> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }
}
