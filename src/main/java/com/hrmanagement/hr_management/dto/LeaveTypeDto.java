package com.hrmanagement.hr_management.dto;

import lombok.Data;

@Data
public class LeaveTypeDto {
    private Long id;
    private String name;
    private Integer defaultDays;
}
