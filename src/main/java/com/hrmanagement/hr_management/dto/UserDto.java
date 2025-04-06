package com.hrmanagement.hr_management.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Data
public class UserDto {


    private Long id;

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name should be 2-50 characters")
    private String name;

    @Size(min = 6, max = 20, message = "Password must be between 6-20 characters")
    private String password;

    @Email(message = "Email should be valid")
    @NotBlank
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be valid")
    private String phoneNumber;


    private RoleDto role;


    private DepartmentDto department;

    private UserDto manager;

    private LocalDate hireDate;

     @NotBlank(message = "created time is required")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
