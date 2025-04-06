package com.hrmanagement.hr_management.dto;

import com.hrmanagement.hr_management.enums.ApprovalStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class LeaveApprovalDto {
    private Long id;



    @NotBlank(message = "leaveRequest is required")
    private LeaveRequestDto leaveRequest;

    @NotBlank(message = "approvedBy is required")
    private UserDto approvedBy;

    @NotBlank(message = "status is required")
    private ApprovalStatus status = ApprovalStatus.PENDING;

    @NotBlank(message = "createAt is required")
    private LocalDateTime createAt = LocalDateTime.now();

    private LocalDateTime approvedAt;
}
