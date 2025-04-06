package com.hrmanagement.hr_management.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectDto {
    private Long id;

    @NotBlank
    private String name;
    private String description;
}
