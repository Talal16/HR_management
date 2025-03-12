package com.hrmanagement.hr_management.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}