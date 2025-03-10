package com.hrmanagement.hr_management.dto;

import com.hrmanagement.hr_management.models.ApprovalStatus;


import java.time.LocalDateTime;

public class LeaveAprovalDto {
    private Long id;

    private LeaveRequestDto leaveRequest;

    private UserDto approvedBy;

    private ApprovalStatus status = ApprovalStatus.PENDING;

    private LocalDateTime approvalTimestamp = LocalDateTime.now();
}
