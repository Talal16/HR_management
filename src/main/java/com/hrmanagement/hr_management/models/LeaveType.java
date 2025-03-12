package com.hrmanagement.hr_management.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data

@Table(name = "leave_types")
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @Column(name = "default_days", nullable = false)
    private Integer defaultDays;
}