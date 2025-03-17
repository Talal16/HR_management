package com.hrmanagement.hr_management.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

   @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = true )
    @JoinColumn(name = "role_id", nullable = true)
    private Role role;

    @ManyToOne(fetch=FetchType.LAZY,  optional = true)
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @ManyToOne(fetch=FetchType.LAZY,  optional = true)
    @JoinColumn(name = "manager_id", nullable = true)
    private User manager;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}