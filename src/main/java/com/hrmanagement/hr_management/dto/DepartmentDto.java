package com.hrmanagement.hr_management.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;
    private String description;
    private Long manager;
}
