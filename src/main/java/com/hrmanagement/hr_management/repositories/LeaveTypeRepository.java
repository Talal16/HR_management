package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}