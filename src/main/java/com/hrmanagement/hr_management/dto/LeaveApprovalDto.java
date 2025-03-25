package com.hrmanagement.hr_management.dto;

import com.hrmanagement.hr_management.enums.ApprovalStatus;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class LeaveApprovalDto {
    private Long id;

    private LeaveRequestDto leaveRequest;

    private UserDto approvedBy;

    private ApprovalStatus status = ApprovalStatus.PENDING;

    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime approvedAt;
}
