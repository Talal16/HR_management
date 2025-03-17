package com.hrmanagement.hr_management.models;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data

@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false )
    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.LAZY,optional = true )
    @JoinColumn(name = "manager_id", nullable = true)
    private User manager;
}