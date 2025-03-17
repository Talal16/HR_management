package com.hrmanagement.hr_management.dto;


import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
    private UserDto manager;
}
