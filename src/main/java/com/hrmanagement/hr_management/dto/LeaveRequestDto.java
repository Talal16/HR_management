package com.hrmanagement.hr_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class LeaveRequestDto {
    private Long id;

    @NotBlank(message = "UserDto is required")
    private UserDto user;

    @NotBlank(message = "LeaveTypeDto is required")
    private LeaveTypeDto leaveType;

    @NotBlank(message = "startDate is required")
    private LocalDate startDate;

    @NotBlank(message = "endDate is required")
    private LocalDate endDate;

    @NotBlank(message = "createdAt is required")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt ;
}
