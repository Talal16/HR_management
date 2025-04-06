package com.hrmanagement.hr_management.repositories;

import com.hrmanagement.hr_management.models.LeaveApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveApprovalRepository extends JpaRepository<LeaveApproval, Long> {
}