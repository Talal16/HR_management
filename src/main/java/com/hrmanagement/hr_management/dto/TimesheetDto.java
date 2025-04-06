package com.hrmanagement.hr_management.dto;



import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TimesheetDto {

    private Long id;

    private UserDto user;

    private ProjectDto project;

    private LocalDateTime startTime;
    
    private LocalDateTime endTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
