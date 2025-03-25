package com.hrmanagement.hr_management.controllers;

import com.hrmanagement.hr_management.dto.LeaveApprovalDto;
import com.hrmanagement.hr_management.services.LeaveApprovalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leaveApproval")
public class LeaveApprovalController {
    private final LeaveApprovalService leaveApprovalService;

    public LeaveApprovalController(LeaveApprovalService leaveApprovalService) {
        this.leaveApprovalService = leaveApprovalService;
    }

    //create a new leave approval
    @Operation(summary = "create a new leave approval")
    @PostMapping
    public LeaveApprovalDto createLeaveApproval(@Valid @RequestBody LeaveApprovalDto leaveApprovalDto) {
        return leaveApprovalService.createLeaveApproval(leaveApprovalDto);
    }

    // get leave approval by id
    @Operation(summary = "get leave approval by id")
    @GetMapping("/{id}")
    public LeaveApprovalDto getLeaveApprovalById(@PathVariable Long id) {
        return leaveApprovalService.getLeaveApproval(id);
    }

    // update leave approval
    @Operation(summary = "update leave approval")
    @PutMapping("/{id}")
    public LeaveApprovalDto updateLeaveApproval(@PathVariable Long id, @Valid @RequestBody LeaveApprovalDto leaveApprovalDto) {
        return leaveApprovalService.updateLeaveApproval(id, leaveApprovalDto);
    }

    // delete leave approval
    @Operation(summary = "delete leave approval")
    @DeleteMapping("/{id}")

    public void deleteLeaveApproval(@PathVariable Long id) {
        leaveApprovalService.deleteLeaveApproval(id);
    }

    // get all leave approvals
    @Operation(summary = "get all leave approvals")
    @GetMapping
    public List<LeaveApprovalDto> getAllLeaveApprovals() {
        return leaveApprovalService.getAllLeaveApprovals();
    }

}
