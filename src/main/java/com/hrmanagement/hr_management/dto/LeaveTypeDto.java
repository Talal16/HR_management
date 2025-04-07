package com.hrmanagement.hr_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeaveTypeDto {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "defaultDays is required")
    private Integer defaultDays;
}
