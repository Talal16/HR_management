package com.hrmanagement.hr_management.controllers;


import com.hrmanagement.hr_management.dto.LeaveTypeDto;
import com.hrmanagement.hr_management.services.LeaveTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/leaveType")
@Tag(name = "  Leave types controller ",description = " APIs for managing leave types" )
public class LeaveTypeController {
    @Autowired
    private LeaveTypeService leaveTypeService;

    @Operation(summary = "create a new leave type")
    @PostMapping
    public LeaveTypeDto createLeaveType(@RequestBody LeaveTypeDto leaveTypeDto) {
        return leaveTypeService.createLeaveType(leaveTypeDto);
    }

    @Operation(summary = "get leave type by id")
    @GetMapping("/{id}")
    public LeaveTypeDto getLeaveTypeById(@PathVariable Long id) {
        return leaveTypeService.getLeaveType(id);
    }

    @Operation(summary = "update leave type")
    @PutMapping("/{id}")
    public LeaveTypeDto updateLeaveType(@PathVariable Long id, @RequestBody LeaveTypeDto leaveTypeDto) {
        return leaveTypeService.updateLeaveType(id, leaveTypeDto);
    }

    @Operation(summary = "delete leave type")
    @DeleteMapping("/{id}")
    public void deleteLeaveType(@PathVariable Long id) {
        leaveTypeService.deleteLeaveType(id);
    }

    @Operation(summary = "get all leave types")
    @GetMapping
    public List<LeaveTypeDto> getAllLeaveTypes() {
        return leaveTypeService.getAllLeaveTypes();
    }

}
