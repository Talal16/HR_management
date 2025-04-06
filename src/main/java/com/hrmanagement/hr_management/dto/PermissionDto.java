package com.hrmanagement.hr_management.dto;
import com.hrmanagement.hr_management.enums.ApprovalStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PermissionDto {

    private long id;

    private String name;
    private UserDto user;
    private ApprovalStatus stutas;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}