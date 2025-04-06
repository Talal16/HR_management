package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

