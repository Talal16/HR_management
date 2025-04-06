package com.hrmanagement.hr_management.dto;


import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Data
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private RoleDto role;
    private DepartmentDto department;
    private UserDto manager;
    private LocalDate hireDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
