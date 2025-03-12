package com.hrmanagement.hr_management.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private RoleDto role;
    private DepartmentDto department;
    private UserDto manager;
    private LocalDate hireDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
