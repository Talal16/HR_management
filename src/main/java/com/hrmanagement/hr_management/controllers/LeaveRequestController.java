package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.LeaveRequestDto;
import com.hrmanagement.hr_management.services.LeaveRequestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leaveRequest")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    //create a new leave request
    @Operation(summary = "create a new leave request")
    @PostMapping
    public LeaveRequestDto createLeaveRequest(@RequestBody LeaveRequestDto leaveRequestDto) {
        return leaveRequestService.createLeaveRequest(leaveRequestDto);
    }

    // get leave request by id
    @Operation(summary = "get leave request by id")
    @GetMapping("/{id}")
    public LeaveRequestDto getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.getLeaveRequest(id);
    }

    // update leave request
    @Operation(summary = "update leave request")

    @PutMapping("/{id}")
    public LeaveRequestDto updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequestDto leaveRequestDto) {
        return leaveRequestService.updateLeaveRequest(id, leaveRequestDto);
    }
    // delete leave request
    @Operation(summary = "delete leave request")
    @DeleteMapping("/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
    }

    // get all leave requests
    @Operation(summary = "get all leave requests")

    @GetMapping
    public List<LeaveRequestDto> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }


}
