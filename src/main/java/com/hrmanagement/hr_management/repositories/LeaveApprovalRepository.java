package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {
}