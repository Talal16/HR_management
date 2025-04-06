package com.hrmanagement.hr_management.repositories;


import com.hrmanagement.hr_management.models.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}