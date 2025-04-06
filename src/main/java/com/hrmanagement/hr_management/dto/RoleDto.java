package com.hrmanagement.hr_management.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDto {
    private Long id;

    @NotBlank
    private String roleName;
}
