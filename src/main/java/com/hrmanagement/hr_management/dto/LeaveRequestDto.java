package com.hrmanagement.hr_management.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeaveRequestDto {
    private Long id;


    private UserDto user;


    private LeaveTypeDto leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt ;
}
