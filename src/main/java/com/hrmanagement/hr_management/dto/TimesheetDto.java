package com.hrmanagement.hr_management.dto;



import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
@Data
public class TimesheetDto {

    private Long id;

    @NotBlank(message = "UserDto is required")

    private UserDto user;


    @NotBlank(message = "ProjectDto is required")
    private ProjectDto project;

    @NotBlank(message = "startTime is required")
    private LocalDateTime startTime;
    
    private LocalDateTime endTime;

    @NotBlank(message = "createdAt is required")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
