package com.hrmanagement.hr_management.dto;
import com.hrmanagement.hr_management.enums.ApprovalStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PermissionDto {

    private long id;
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "UserDto is required")
    private UserDto user;

    @NotBlank(message = "ApprovalStatus is required")
    private ApprovalStatus stutas;

    @NotBlank(message = "startTime  is required")
    private LocalDateTime startTime;

    @NotBlank(message = "endTime  is required")
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}